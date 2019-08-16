package com.ytd.dao.chargeDao;


import com.ytd.pojo.BankCard;
import com.ytd.pojo.RechargeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RechargeLogDao extends JpaRepository<RechargeLog,Integer>, JpaSpecificationExecutor<RechargeLog> {


    //查询用户充值的单日限额
    @Query(value = "select  * from recharge_log where userId = ?1 and rechargeTime = ?1",nativeQuery = true)
    List<RechargeLog> selectRechargeLogByUserIdAndParam(Map<String,Object> rechargeLogmap);


}
