package com.sust.community.controller;

import com.sust.community.enums.PageEnum;
import com.sust.community.exception.CustomizeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SunnyGrocery on 2019/11/22 19:59
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomizeErrorController implements ErrorController {
    @Value("${error.path:/error}")
    private String path = "/error";

    @Override
    public String getErrorPath() {
        return path;
    }

    /**
     * 将错误信息直接交给 {@link  com.sust.community.advice.CustomizeExceptionHandler} 处理
     */
    public void error() {
        throw new CustomizeException(PageEnum.PAGE_NUM_NOT_FOUND);
    }
}
