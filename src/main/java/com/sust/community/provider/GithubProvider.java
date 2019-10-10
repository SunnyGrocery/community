package com.sust.community.provider;

import com.alibaba.fastjson.JSON;
import com.sust.community.dto.AccessTokenDTO;
import com.sust.community.dto.UserDTO;
import com.sust.community.enums.AuthorizeEnum;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by SunnyGrocery on 2019/10/6 14:20
 */
@Component
public class GithubProvider {
    /**
     * 获取github第三方token
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url(AuthorizeEnum.ACCESS_TOKEN_URL.getData())
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String temp = response.body().string();
            //处理回调的数据，提取access_token
            return temp.split("=")[1].split("&")[0];

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserDTO getUser(String access_token) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(AuthorizeEnum.USER_URL.getData() + "?access_token=" + access_token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return JSON.parseObject(response.body().string(), UserDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
