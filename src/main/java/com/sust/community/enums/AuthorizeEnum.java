package com.sust.community.enums;

/**
 * Created by SunnyGrocery on 2019/10/6 14:44
 */
public enum AuthorizeEnum {


    AUTHORIZE_URL("https://github.com/login/oauth/authorize"),
    ACCESS_TOKEN_URL("https://github.com/login/oauth/access_token"),
    USER_URL("https://api.github.com/user"),
    ;

    private String data;

    public String getData() {
        return data;
    }

    AuthorizeEnum(String data) {
        this.data = data;
    }
}
