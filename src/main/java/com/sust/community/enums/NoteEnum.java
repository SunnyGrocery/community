package com.sust.community.enums;

/**
 * Created by SunnyGrocery on 2019/11/22 20:40
 */
public enum NoteEnum implements CustomizeExceptionEnum {
    FAIL_EXCEPTION(500, "错误测试"),
    ;
    private int code;
    private String msg;

    NoteEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
