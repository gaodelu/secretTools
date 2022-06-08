package com.mochi.common.enumutil;

public enum ResponseEnum {

    PB_0001("0001", "There is no such conversion option"),
    PB_0002("0002", "The entered data is empty"),
    PB_0003("0003", "encrypt error"),
    PB_0004("0004", "The length of the key is less than 8"),
    PB_0005("0005", "decrypt error"),
    PB_0006("0006", "The length of the key is not a multiple of 8"),
    PB_0007("0007", "Data error!");

    private String respCode;

    private String respMsg;

    public String getRespCode() {
        return respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    ResponseEnum(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }
}
