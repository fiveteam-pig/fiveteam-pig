package com.ytd.dao;

import com.ytd.pojo.Trade;
import com.ytd.pojo.UserMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TradeDao extends JpaRepository<Trade,Integer>,JpaSpecificationExecutor<Trade> {

    @Query(value ="select  * from Trade where serial_Number= ?1",nativeQuery = true)
    Trade selectTradeBySerialNumber(String serialNumber);


    @Modifying
    @Transactional
    @Query(value = "update trade set messageId=#{messageId}," +
            "responseMessage=#{responseMessage},requestTradingAmount=#{requestTradingAmount},responseTradingAmount=#{responseTradingAmount}," +
            "tradeStatus=#{tradeStatus},tradeDate=#{tradeDate},loanid=#{loanid},version=#{version},#{qd}, where serialNumber = ?1",nativeQuery = true)
    void toUpdateTrade(Trade trade);
}
