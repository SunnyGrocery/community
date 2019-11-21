package com.sust.community.intercepter;

import com.sust.community.dto.UserDTO;
import com.sust.community.model.User;
import com.sust.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SunnyGrocery on 2019/11/9 18:25
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    /**
     * 根据 Cookies 给 request写入 UserDTO(user)和 User(userRaw)对象
     * 若 Cookie为空或 Cookie中 token字段验证失败，则 均为空
     * 这里也是为了效率考虑才这样做
     *
     * @return true 这里 Interceptor只做验证，所有请求放行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        User user;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String token = cookie.getValue();
                if ("token".equals(cookie.getName())) {
                    user = userService.findByToken(token);
                    //token正确则回填“user”信息
                    if (user != null) {
                        UserDTO userDTO = UserDTO.fromUser(user);
                        request.setAttribute("userRaw", user);
                        request.getSession().setAttribute("user", userDTO);
                    }
                    //否则“user”为空
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
