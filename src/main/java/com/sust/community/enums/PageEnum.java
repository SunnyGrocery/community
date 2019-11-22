package com.sust.community.enums;

/**
 * Created by SunnyGrocery on 2019/11/22 20:56
 */
public enum PageEnum implements CustomizeExceptionEnum {
    PAGE_NUM_NOT_FOUND(404, "Page Not Found"),
    ;
    private int code;
    private String msg;

    PageEnum(int code, String msg) {
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
