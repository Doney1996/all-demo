package com.doney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    /**
     * 余额
     */
    private Long balance;

}