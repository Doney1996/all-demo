package com.doney.entity;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:11
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -80050879268062566L;
    
    private Long id;
    /**
    * 账户名称
    */
    private String accountName;
    /**
    * 账户类型
    */
    private Long accountType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountType() {
        return accountType;
    }

    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

}