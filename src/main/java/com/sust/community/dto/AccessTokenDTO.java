package com.sust.community.dto;

import lombok.Data;

/**
 * Created by SunnyGrocery on 2019/10/6 14:23
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
