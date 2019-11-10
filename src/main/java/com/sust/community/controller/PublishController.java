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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
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

    @GetMapping("/publish/{noteId}")
    public String edit(@PathVariable(value = "noteId") Integer noteId, Model model) {
        User user = (User) request.getAttribute("userRaw");
        Note note = noteService.findById(noteId);
        if (user != null && note != null && user.getId().equals(note.getUser().getId())) {
            NoteDTO noteDTO = NoteDTO.fromNote(note);
            model.addAttribute("title", noteDTO.getTitle());
            model.addAttribute("description", noteDTO.getDescription());
            model.addAttribute("label", noteDTO.getLabel());
            model.addAttribute("noteId", noteDTO.getNoteId());
            return "publish";
        }
        return "redirect:/";
    }

    @GetMapping("/publish")
    public String publish() {
        User user = (User) request.getAttribute("userRaw");
        if (user == null) {
            return "redirect:/";
        }
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
        User user = (User) request.getAttribute("userRaw");
        if (user == null) {
            return "redirect:/";
        }
        if (noteDTO.getTitle() == null || "".equals(noteDTO.getTitle().trim()) || noteDTO.getDescription() == null || "".equals(noteDTO.getDescription().trim()) || noteDTO.getLabel() == null || "".equals(noteDTO.getLabel().trim())) {
            model.addAttribute("error", "非法空提交");
            model.addAttribute("title", noteDTO.getTitle());
            model.addAttribute("description", noteDTO.getDescription());
            model.addAttribute("label", noteDTO.getLabel());
            model.addAttribute("noteId", noteDTO.getNoteId());
            return "publish";
        }
        //验证结束

        Note note = Note.fromNoteDTO(noteDTO);
        Integer noteId = noteDTO.getNoteId();
        if (noteId == null) {
            note.setUser(user);
            noteService.save(note);
            return "redirect:/note/" + note.getId();
        } else {
            Note noteTemp = noteService.findById(noteId);
            //验证note所属User是否正确
            if (noteTemp != null && noteTemp.getUser().getId().equals(user.getId())) {
                note.setUser(user);
                noteService.change(note);
                return "redirect:/note/" + noteId;
            }
        }
        return "redirect:/";
    }
}
