package com.doney.japdemo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class Profile extends BaseEntity {
    private Map<Object, Object> map;
}
