package com.ytd.service.rechargeImpl;

import com.ytd.dao.chargeDao.BankBinDao;
import com.ytd.dao.chargeDao.ProRechargeDao;
import com.ytd.dao.chargeDao.RechargeLogDao;
import com.ytd.pojo.BankBin;
import com.ytd.pojo.BankCard;
import com.ytd.pojo.RechargeLog;
import com.ytd.pojo.UserMain;
import com.ytd.service.UserMainService;
import com.ytd.service.impl.UserMainServiceImpl;
import com.ytd.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProRechargeServiceImpl {

    @Autowired
    private UserMainService userMainService;

    @Autowired
    private ProRechargeDao proRechargeDao;

    @Autowired
    private BankBinDao bankBinDao;

    @Autowired
    private RechargeLogDao rechargeLogDao;


    private static final Logger logger = LoggerFactory.getLogger(UserMainServiceImpl.class);//log4j


     /**
     * 充值，校验参数
     * @param jxMap
     * @return
    @Override
    */
    public Map<String, Object> proRecharge(Map<String, String> jxMap) {
       Map< String, Object> resultMap = new HashMap<>();

        // 验证用户是否注册
        UserMain userMain = userMainService.selectUserMainByUserId(Integer.valueOf(jxMap.get("userId")));
        if (userMain == null) {
            logger.error("用户·江西银行开户 （合规），用户信息不存在",jxMap.get("userId"), jxMap.get("mobile"));
            return RestultHandle.IsNotRegister();
        }


        // 验证用户是否开过户
        if (StringUtils.isBlank(userMain.getUserCode())) {
            logger.error("用户·江西银行开户 （合规），未开通银行存管账户", jxMap.get("userId"), userMain.getUserCode());
            return RestultHandle.IsNotOpenAccount();
        }

        // 验证是否设置交易密码
        if (userMain.getIsPwdSet().equals(0)) {
            logger.error("用户·江西银行开户 （合规），未设置交易密码", jxMap.get("userId"), userMain.getUserCode());
            resultMap.put("error","已开户");
            return resultMap;
        }

        //验证是否绑卡
        BankCard bankCard = proRechargeDao.selectBankCardByUserId(userMain.getUserId());
        if(bankCard == null || bankCard.isBinded()){
            logger.error("用户="+userMain.getUserId()+".充值，未绑定储蓄卡",userMain.getUserId());
            return  RestultHandle.IsNotBindBankCard();
        }

        //验证用户充值单笔限额
        BankBin  bankBin = bankBinDao.selectBankBinByCardNo(bankCard.getCardNo().substring(0,6));//根据bank_Card表CardNo的前六位，来查询bank_Bin表的单笔限额
        BigDecimal amount = new BigDecimal(jxMap.get("amount"));  //获取金额

        if(amount.compareTo(new BigDecimal(bankBin.getSingleQuota().replace("万","0000"))) > 0){
            logger.error("用户="+userMain.getUserId()+".充值金额="+amount+"超过单笔限额="+bankBin.getSingleQuota()+"");
            return RestultHandle.IsExcessSingleQuota();
        }

        //验证用户充值单日限额
        Map<String,Object> rechargeLogmap = new HashMap<String, Object>();

        rechargeLogmap.put("userId",userMain.getUserId());
        rechargeLogmap.put("rechargeTime", DateUtil.format_YYYY_MM_dd( new Date()));//支付时间

        //根据recharge_log表里面的userId和支付时间查询这个list集合
        List<RechargeLog> rechargeLogList = rechargeLogDao.selectRechargeLogByUserIdAndParam(rechargeLogmap);
        BigDecimal dayAmount = BigDecimal.ZERO.add(amount);
        for(RechargeLog rechargeLog : rechargeLogList){
             dayAmount = dayAmount.add(rechargeLog.getAmount());
        }
        if(dayAmount.compareTo(new BigDecimal(bankBin.getDayQuota().replace("万","0000")))>0){
            logger.error("用户="+userMain.getUserId()+".充值金额="+amount+"超过单日限额="+bankBin.getDayQuota()+"");
            return RestultHandle.IsExcessDayQuota();
        }
        return RestultHandle.IsDefaultSuccess();
    }

}
