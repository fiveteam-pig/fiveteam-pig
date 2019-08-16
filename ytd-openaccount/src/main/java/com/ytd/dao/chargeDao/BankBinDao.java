package com.ytd.dao.chargeDao;


import com.ytd.pojo.BankBin;
import com.ytd.pojo.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface BankBinDao extends JpaRepository<BankBin,Integer>, JpaSpecificationExecutor<BankBin> {




    //查询用户充值单笔限额
    @Query(value = "select  * from bank_bin where bankBin = ?1",nativeQuery = true)
    BankBin selectBankBinByCardNo(String substring);


}
