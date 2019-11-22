package com.sust.community.exception;

import com.sust.community.enums.CustomizeExceptionEnum;

/**
 * Created by SunnyGrocery on 2019/11/21 23:08
 */
public class CustomizeException extends RuntimeException {
    private int code;

    public CustomizeException(CustomizeExceptionEnum customizeExceptionEnum) {
        this(customizeExceptionEnum.getCode(), customizeExceptionEnum.getMsg());
    }

    public CustomizeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return super.getMessage();
    }
}
