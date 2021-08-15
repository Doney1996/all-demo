package com.doney.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 交易表(Trad)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("trad")
public class Trad implements Serializable {
    private static final long serialVersionUID = -94791217186974984L;

    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 交易时间
    */
    private Date trandDate;
    /**
    * 交易分类
    */
    private Long tradClassification;
    /**
    * 交易类型
    */
    private Long tradType;
    /**
    * 删除标志
    */
    private Object delFlag;
    /**
    * 备注
    */
    private String remark;
    /**
    * 标签
    */
    private String tag;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 状态
    */
    private Long status;

}