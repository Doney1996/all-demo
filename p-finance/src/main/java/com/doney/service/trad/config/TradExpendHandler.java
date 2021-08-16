package com.doney.service.trad.config;

import com.doney.dto.TradRequest;
import com.doney.entity.Trad;

/**
 * 日常支出
 */
public class TradExpendHandler implements TradHandler {
    @Override
    public String getSubmitType() {
        return  TradClassificationEnum.ExpendHandler.getCode();
    }

    @Override
    public Trad handleSubmit(TradRequest request) {
        return null;
    }
}
