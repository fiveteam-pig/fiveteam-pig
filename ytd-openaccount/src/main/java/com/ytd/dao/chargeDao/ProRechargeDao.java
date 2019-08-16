package com.ytd.dao.chargeDao;


import com.ytd.pojo.BankBin;
import com.ytd.pojo.BankCard;
import com.ytd.pojo.RechargeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProRechargeDao extends JpaRepository<BankCard,Integer>, JpaSpecificationExecutor<BankCard> {


 ///查询是否绑卡
    @Query(value = "select * from bank_card where userId = ?1",nativeQuery = true)
    BankCard selectBankCardByUserId(Integer userId);

}
