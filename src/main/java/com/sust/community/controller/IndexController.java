package com.sust.community.controller;

import com.github.pagehelper.PageInfo;
import com.sust.community.dto.NoteDTO;
import com.sust.community.dto.PageInfoDTO;
import com.sust.community.dto.UserDTO;
import com.sust.community.model.Note;
import com.sust.community.model.User;
import com.sust.community.provider.GithubProvider;
import com.sust.community.service.NoteService;
import com.sust.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private NoteService noteService;

    @GetMapping(value = {"/{page}", "/"})
    public String index(Model model, @PathVariable(required = false, value = "page") Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        }

        List<Note> noteList = noteService.findPage(pageNum, 15);

        List<NoteDTO> noteDTOList = new ArrayList<>(noteList.size());
        for (Note note : noteList) {
            noteDTOList.add(NoteDTO.fromNote(note));
        }
        //帖子信息
        model.addAttribute("notes", noteDTOList);
        //分页栏信息
        PageInfoDTO pageInfoDTO = PageInfoDTO.of(PageInfo.of(noteList));
        model.addAttribute("pageInfo", pageInfoDTO);

        return "index";
    }
}
