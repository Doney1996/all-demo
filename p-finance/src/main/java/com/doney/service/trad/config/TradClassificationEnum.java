package com.doney.service.trad.config;

/**
 * Trad 分类枚举
 */
public enum TradClassificationEnum {
    IncomeHandler("","",TradIncomeHandler.class),
    ExpendHandler("","",TradExpendHandler.class),
    TransferHandler("","",TradTransferHandler.class),
    ;
    /**
     * 简码
     */
    private final String code;


    /**
     * 描述
     */
    private final String description;

    /**
     * 数据访问器
     */
    private final Class<? extends TradHandler> handlerClass;

    TradClassificationEnum(String code, String description, Class<? extends TradHandler> handlerClass) {
        this.code = code;
        this.description = description;
        this.handlerClass = handlerClass;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Class<? extends TradHandler> getHandlerClass() {
        return handlerClass;
    }
}
