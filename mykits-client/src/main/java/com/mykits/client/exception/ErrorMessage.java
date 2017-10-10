package com.mykits.client.exception;

public enum ErrorMessage {
    INVALID_ARGUMENT_ERROR("1001", "输入内容不合法。", "Illegal contents.");

    private String code;
    private String zhMsg;
    private String enMsg;

    private ErrorMessage(String code, String zhMsg, String enMsg) {
        this.code = code;
        this.zhMsg = zhMsg;
        this.enMsg = enMsg;
    }

    public String getCode() {
        return code;
    }

    public String getZhMsg() {
        return zhMsg;
    }

    public String getEnMsg() {
        return enMsg;
    }
}
