package com.sust.community.controller;

import com.sust.community.dto.NoteDTO;
import com.sust.community.dto.UserDTO;
import com.sust.community.model.Note;
import com.sust.community.model.User;
import com.sust.community.service.NoteService;
import com.sust.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by SunnyGrocery on 2019/10/11 11:00
 */
@Controller
public class PublishController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    /**
     * 前端点击提交按钮之后，浏览器POST请求提交到本方法
     * 本方法做表单验证和处理
     * <p>
     * 成功 -> 返回主页
     * 失败 -> 返回错误提示，并保留原来POST到服务端信息
     *
     * @param noteDTO 包含 title&description&label 三个字段
     * @return 做完验证内部跳转到 `/publish GET`
     */
    @PostMapping("/publish")
    public String doPublish(NoteDTO noteDTO, Model model) {
        // 这里做一个极不优雅的权限验证
        User user = null;
        Cookie[] cookies = request.getCookies();
        boolean loggedIn = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String token = cookie.getValue();
                if ("token".equals(cookie.getName())) {
                    loggedIn = true;
                    //验证Token是否正确存在
                    user = userService.findByToken(token);
                    break;
                }
            }
        }
        if (!loggedIn) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        if (user == null) {
            model.addAttribute("error", "用户状态不正确");
            return "publish";
        }else {
            request.getSession().setAttribute("user", UserDTO.fromUser(user));
        }

        if (noteDTO.getTitle() == null || "".equals(noteDTO.getTitle().trim()) || noteDTO.getDescription() == null || "".equals(noteDTO.getDescription().trim()) || noteDTO.getLabel() == null || "".equals(noteDTO.getLabel().trim())) {
            model.addAttribute("error", "非法空提交");
            return "publish";
        }
        //验证结束

        Note note = Note.fromNoteDTO(noteDTO);
        note.setUser(user);
        noteService.save(note);
        return "redirect:/";
    }
}
