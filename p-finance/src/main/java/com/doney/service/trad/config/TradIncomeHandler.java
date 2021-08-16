package com.doney.service.trad.config;

import com.doney.dto.TradRequest;
import com.doney.entity.Trad;

/**
 * 日常收入
 */
public class TradIncomeHandler implements TradHandler {
    @Override
    public String getSubmitType() {
        return null;
    }

    @Override
    public Trad handleSubmit(TradRequest request) {
        return null;
    }
}
