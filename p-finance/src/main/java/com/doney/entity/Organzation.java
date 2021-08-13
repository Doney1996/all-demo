package com.doney.entity;

import java.io.Serializable;

/**
 * 单位机构表(Organzation)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
public class Organzation implements Serializable {
    private static final long serialVersionUID = -96008197756377718L;
    
    private Long id;
    /**
    * 单位名称
    */
    private String name;
    /**
    * 单位分类
    */
    private Long type;
    /**
    * 单位类型
    */
    private Long classification;


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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getClassification() {
        return classification;
    }

    public void setClassification(Long classification) {
        this.classification = classification;
    }

}