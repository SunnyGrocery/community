package com.sust.community.advice;

import com.sust.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by SunnyGrocery on 2019/11/21 21:19
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(CustomizeException.class)
    public String customizeExceptionHandel(Model model, CustomizeException ex) {
        model.addAttribute("msg", "Something went wrong：" + ex.getMsg());
        return "error";
    }

    @ExceptionHandler()
    public String unknownExceptionHandel(Model model, RuntimeException ex) {
        model.addAttribute("msg", "An unknown error occurred:" + ex.getClass().getSimpleName());
        return "error";
    }
}
