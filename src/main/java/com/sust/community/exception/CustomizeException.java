package com.sust.community.exception;

import com.sust.community.enums.ResultEnum;
import lombok.Getter;

/**
 * Created by SunnyGrocery on 2019/11/21 23:08
 */
public class CustomizeException extends RuntimeException {
    private int code;

    public CustomizeException(ResultEnum resultEnum) {
        this(resultEnum.getCode(), resultEnum.getMsg());
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
