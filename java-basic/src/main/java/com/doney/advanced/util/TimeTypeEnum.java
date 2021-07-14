package com.doney.advanced.util;

import org.springframework.util.StringUtils;

/**
 * @author 欧东林 2020年12月21日
 * 时间类型（DY：当月 SY：上月 BJD：本季度 SJD：上季度 BN：本年 SN：上年）
 */
public enum TimeTypeEnum {

    /**当月*/
    DY,
    /**上月*/
    SY,
    /**本季度*/
    BJD,
    /**上季度*/
    SJD,
    /**本年*/
    BN,
    /**上年*/
    SN
    ;

    /** 判断参数合法性 */
    public static boolean isValidName(String name) {
        if (StringUtils.isEmpty(name)) {
            return false;
        }
        for (TimeTypeEnum userStatusEnum : TimeTypeEnum.values()) {
            if (userStatusEnum.name().equals(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}