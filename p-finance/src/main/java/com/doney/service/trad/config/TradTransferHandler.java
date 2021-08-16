package com.doney.service.trad.config;

import com.doney.dto.TradRequest;
import com.doney.entity.Trad;

/**
 * 内部转账
 */
public class TradTransferHandler implements TradHandler {
    @Override
    public String getSubmitType() {
        return null;
    }

    @Override
    public Trad handleSubmit(TradRequest request) {
        return null;
    }
}
