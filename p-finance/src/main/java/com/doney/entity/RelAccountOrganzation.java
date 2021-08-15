package com.doney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RelAccountOrganzation)实体类
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelAccountOrganzation implements Serializable {
    private static final long serialVersionUID = 255087980299983811L;
    
    private Long id;
    
    private Long accountId;
    
    private Long organzationId;
}