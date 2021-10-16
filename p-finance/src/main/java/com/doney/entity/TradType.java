package com.doney.entity;

import java.io.Serializable;

/**
 * 交易类型(TradType)实体类
 *
 * @author makejava
 * @since 2021-08-16 19:38:35
 */
public class TradType implements Serializable {
    private static final long serialVersionUID = 531375845605321614L;
    
    private Long id;
    /**
    * 交易类型名称
    */
    private String name;
    /**
    * 枚举值
    */
    private String value;
    /**
    * 父级id
    */
    private Long pId;
    /**
    * 收支
    */
    private Object type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getPId() {
        return pId;
    }

    public void setPId(Long pId) {
        this.pId = pId;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

}