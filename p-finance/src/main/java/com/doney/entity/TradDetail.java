package com.doney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 交易详情(TradDetail)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}