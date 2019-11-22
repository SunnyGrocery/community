package com.sust.community.advice;

import com.sust.community.enums.PageEnum;
import com.sust.community.exception.CustomizeException;
import com.sust.community.util.MsgUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Created by SunnyGrocery on 2019/11/21 21:19
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    /**
     * 处理自定义异常{@link CustomizeException}
     */
    @ExceptionHandler(CustomizeException.class)
    public String customizeExceptionHandel(Model model, CustomizeException ex) {
        model.addAttribute("msg", MsgUtil.someThingWrong(ex.getMsg()));
        return "error";
    }
    /**
     * 处理Controller路径映射中的方法类型不匹配
     * 即当Controller中传入错误的PathVariable无法类型转换时，将其处理为404错误
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String methodArgumentTypeMismatchExceptionHandel(Model model, MethodArgumentTypeMismatchException ex) {
        model.addAttribute("msg", MsgUtil.someThingWrong(PageEnum.PAGE_NUM_NOT_FOUND.getMsg()));
        return "error";
    }
    /**
     * 处理未知错误
     */
    @ExceptionHandler(Exception.class)
    public String unknownExceptionHandel(Model model, Exception ex) {
        model.addAttribute("msg", MsgUtil.unknownWrong(ex.getClass().getSimpleName()));
        return "error";
    }
}
