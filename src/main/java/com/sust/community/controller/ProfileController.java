package com.sust.community.controller;

import com.github.pagehelper.PageInfo;
import com.sust.community.dto.NoteDTO;
import com.sust.community.dto.PageInfoDTO;
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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunnyGrocery on 2019/11/1 14:51
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    NoteService noteService;
    @Autowired
    UserService userService;

    @GetMapping({"/question/", "/question/{page}"})
    public String question(HttpServletRequest request,
                           Model model,
                           @PathVariable(value = "page", required = false) Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        }
        User user = (User) request.getAttribute("userRaw");
        if (user == null) {
            return "redirect:/";
        }
        List<Note> noteList = noteService.findPageByUserId(user.getId(), pageNum, 15);
        List<NoteDTO> noteDTOList = new ArrayList<>(noteList.size());
        for (Note note : noteList) {
            noteDTOList.add(NoteDTO.fromNote(note));
        }
        PageInfoDTO pageInfoDTO = PageInfoDTO.of(PageInfo.of(noteList));

        model.addAttribute("notes", noteDTOList);
        model.addAttribute("pageInfo", pageInfoDTO);
        return "profile/question";
    }

    @GetMapping({"/replies/{page}", "/replies/"})
    public String replies(HttpServletRequest request,
                          Model model,
                          @PathVariable(value = "page", required = false) Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        }
        User user = (User) request.getAttribute("userRaw");
        if (user == null) {
            return "redirect:/";
        }
        return "profile/replies";
    }
}
