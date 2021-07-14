package com.doney.advanced.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DateBetween {
    private String beginTime;
    private String endTime;

    public String getBeginTime() {
        return beginTime + " 00:00:00";
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime + " 24:00:00";
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
