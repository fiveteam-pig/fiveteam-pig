package com.ytd.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_bin")
public class BankBin {

    @Id
    private Integer id;
    private String bankBin;//卡bin
    private String bankName;//银行全称
    private String bankShortName;//银行简称
    private String singleQuota;//单笔限额
    private String dayQuota;//单日限额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankBin() {
        return bankBin;
    }

    public void setBankBin(String bankBin) {
        this.bankBin = bankBin;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankShortName() {
        return bankShortName;
    }

    public void setBankShortName(String bankShortName) {
        this.bankShortName = bankShortName;
    }

    public String getSingleQuota() {
        return singleQuota;
    }

    public void setSingleQuota(String singleQuota) {
        this.singleQuota = singleQuota;
    }

    public String getDayQuota() {
        return dayQuota;
    }

    public void setDayQuota(String dayQuota) {
        this.dayQuota = dayQuota;
    }
}