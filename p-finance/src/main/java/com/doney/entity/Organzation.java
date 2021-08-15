package com.doney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 单位机构表(Organzation)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}