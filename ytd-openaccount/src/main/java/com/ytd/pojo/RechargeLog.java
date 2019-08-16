package com.ytd.pojo;


import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="recharge_log")
public class RechargeLog {


    @Id
    private Integer rechargeLogId;
    private BigDecimal amount;   //'充值金额'
    private String payId;//'支付id'
    private String rechargeTime;//'支付时间'
    private Integer payType;//'支付类型'
    private Integer userId;//'支付者id'
    private BigDecimal recharge_fee;//''充值费用''
    private BigDecimal reserve_fee_balance;//''预留充值费用余额''
    private Integer flag;//''默认是0未成功，1是成功''


    public Integer getRechargeLogId() {
        return rechargeLogId;
    }

    public void setRechargeLogId(Integer rechargeLogId) {
        this.rechargeLogId = rechargeLogId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(String rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getRecharge_fee() {
        return recharge_fee;
    }

    public void setRecharge_fee(BigDecimal recharge_fee) {
        this.recharge_fee = recharge_fee;
    }

    public BigDecimal getReserve_fee_balance() {
        return reserve_fee_balance;
    }

    public void setReserve_fee_balance(BigDecimal reserve_fee_balance) {
        this.reserve_fee_balance = reserve_fee_balance;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}