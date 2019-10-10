package com.sust.community.controller;

/**
 * Created by SunnyGrocery on 2019/10/6 14:09
 */

import com.sust.community.dto.AccessTokenDTO;
import com.sust.community.dto.UserDTO;
import com.sust.community.model.User;
import com.sust.community.provider.GithubProvider;
import com.sust.community.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.callback.url}")
    private String callbackURL;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private HttpServletResponse httpServletResponse;
    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        //通过code获取token
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(callbackURL);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        UserDTO userDTO = githubProvider.getUser(accessToken);

        System.out.println(userDTO);
        if (userDTO != null) {
            User user = userService.findByAccountId(userDTO.getId());
            if (user == null) {
                //copy
                user = User.fromUserDTOAndGenUUID(userDTO);
                userService.save(user);
            }
            //写cookie
            Cookie cookie = new Cookie("token", user.getToken());
            cookie.setMaxAge(3600);
            httpServletResponse.addCookie(cookie);
            return "redirect:/";
        } else {
            //TODO: 登录失败
            return "redirect:/";

        }
    }
}
