package com.doney.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 交易表(Trad)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
public class Trad implements Serializable {
    private static final long serialVersionUID = -94791217186974984L;
    
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
    * 交易流水号
    */
    private Long tradNumber;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTrandDate() {
        return trandDate;
    }

    public void setTrandDate(Date trandDate) {
        this.trandDate = trandDate;
    }

    public Long getTradClassification() {
        return tradClassification;
    }

    public void setTradClassification(Long tradClassification) {
        this.tradClassification = tradClassification;
    }

    public Long getTradType() {
        return tradType;
    }

    public void setTradType(Long tradType) {
        this.tradType = tradType;
    }

    public Long getTradNumber() {
        return tradNumber;
    }

    public void setTradNumber(Long tradNumber) {
        this.tradNumber = tradNumber;
    }

    public Object getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Object delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}