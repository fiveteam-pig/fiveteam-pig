package com.ytd.service.rechargeImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * 结果处理
 */
@SuppressWarnings("rawtypes")
public class RestultHandle {

    private static Map resultMap = new HashMap();


    /**
     * 默认成功
     * @return
     */
    public static Map IsDefaultSuccess(){
        resultMap.put("retCode","0");
        resultMap.put("retMsg","操作成功");
        return resultMap;
    }
    /**
     * 默认错误
     * @return
     */
    public static Map IsDefaultError(){
        resultMap.put("retCode","1");
        resultMap.put("retMsg","内部错误，请联系客服");
        return resultMap;
    }
    /**
     * 没有登录
     * @return
     */
    public static Map IsNotLogin(){
        resultMap.put("retCode","1000");
        resultMap.put("retMsg","请先登录");
        return resultMap;
    }
    /**
     * 未注册
     * @return
     */
    public static Map IsNotRegister(){
        resultMap.put("retCode","1001");
        resultMap.put("retMsg","用户信息不存在，请尝试重新登录");
        return resultMap;
    }
    /**
     * 登录身份过期，请重新登录
     * @return
     */
    public static Map IsOverLogin(){
        resultMap.put("retCode","1002");
        resultMap.put("retMsg","登录身份过期，请重新登录");
        return resultMap;
    }
    /**
     * 注册，手机号已注册
     * @return
     */
    public static Map IsRegister(){
        resultMap.put("retCode","1104");
        resultMap.put("retMsg","当前手机号已注册");
        return resultMap;
    }
    /**
     * 充值，超过单笔限额
     * @return
     */
    public static Map IsExcessSingleQuota(){
        resultMap.put("retCode","1510");
        resultMap.put("retMsg","超过单笔限额，请更换充值金额");
        return resultMap;
    }
    /**
     * 充值，超过单日限额
     * @return
     */
    public static Map IsExcessDayQuota(){
        resultMap.put("retCode","1511");
        resultMap.put("retMsg","超过单日限额，请使用银行转账进行充值");
        return resultMap;
    }

    /**
     * 余额不足
     * @return
     */
    public static Map IsNotEnoughBalance(){
        resultMap.put("retCode","1512");
        resultMap.put("retMsg","余额不足");
        return resultMap;
    }

    ///未开通银行存管
    public static Map<String,Object> IsNotOpenAccount() {
        resultMap.put("retCode","1500");
        resultMap.put("retMsg","您未开通银行存管账户");
        return resultMap;
    }
    ///未绑卡
    public static Map<String,Object> IsNotBindBankCard() {
        resultMap.put("retCode","1501");
        resultMap.put("retMsg","未绑储蓄卡");
        return resultMap;
    }
    ///已绑定储蓄卡
    public static Map<String,Object> IsBindBankCard() {
        resultMap.put("retCode","1502");
        resultMap.put("retMsg","已绑储蓄卡");
        return resultMap;
    }
}
