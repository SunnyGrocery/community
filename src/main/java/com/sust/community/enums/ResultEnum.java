package com.sust.community.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by SunnyGrocery on 2019/11/21 23:12
 */
@AllArgsConstructor
@Getter
public enum ResultEnum {
    UNAUTHORIZED(401, ""),
    AUTHORIZE_LOGIN_ERROR(1, ""),
    ;


    private int code;
    private String msg;

}
