package com.doney.entity;

import java.io.Serializable;

/**
 * (RelAccountOrganzation)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
public class RelAccountOrganzation implements Serializable {
    private static final long serialVersionUID = 255087980299983811L;
    
    private Long id;
    
    private Long accountId;
    
    private Long organzationId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getOrganzationId() {
        return organzationId;
    }

    public void setOrganzationId(Long organzationId) {
        this.organzationId = organzationId;
    }

}