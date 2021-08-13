package com.doney.entity;

import java.io.Serializable;

/**
 * 交易详情(TradDetail)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:17
 */
public class TradDetail implements Serializable {
    private static final long serialVersionUID = -75174488427752992L;
    
    private Long id;
    /**
    * 交易id
    */
    private Long tradId;
    
    private Long fromAccount;
    
    private Long toAccount;
    /**
    * 交易金额，单位分
    */
    private Long amount;
    /**
    * 类型
    */
    private Long type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTradId() {
        return tradId;
    }

    public void setTradId(Long tradId) {
        this.tradId = tradId;
    }

    public Long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Long getToAccount() {
        return toAccount;
    }

    public void setToAccount(Long toAccount) {
        this.toAccount = toAccount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

}