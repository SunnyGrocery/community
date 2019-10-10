package com.sust.community.controller;

import com.sust.community.dto.UserDTO;
import com.sust.community.model.User;
import com.sust.community.provider.GithubProvider;
import com.sust.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SunnyGrocery on 2019/10/5 19:31
 */
@Controller
public class IndexController {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private HttpServletResponse httpServletResponse;
    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("token".equals(c.getName())) {
                    User user = userService.findByToken(c.getValue());
                    System.out.println(user);
                    if (user != null) {
                        UserDTO userDTO = UserDTO.fromUser(user);
                        httpServletRequest.getSession().setAttribute("user", userDTO);
                    }
                    break;
                }
            }
        }

        return "index";
    }
}
