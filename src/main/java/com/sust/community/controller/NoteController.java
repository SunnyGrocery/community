package com.sust.community.controller;

import com.sust.community.dto.NoteDTO;
import com.sust.community.model.Note;
import com.sust.community.model.User;
import com.sust.community.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SunnyGrocery on 2019/11/10 12:40
 */
@Controller
public class NoteController {
    @Autowired
    NoteService noteService;
    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/note/{noteId}")
    public String note(@PathVariable(value = "noteId") Integer noteId, Model model) {
        Note note = noteService.findById(noteId);
        if (note == null) {
            return "redirect:/";
        }
        User user = note.getUser();
        User userRaw = (User) httpServletRequest.getAttribute("userRaw");

        model.addAttribute("canEdit", false);
        if (userRaw != null && user.getId().equals(userRaw.getId())) {
            model.addAttribute("canEdit", true);
        }
        NoteDTO noteDTO = NoteDTO.fromNote(note);
        model.addAttribute("user", user);
        model.addAttribute("note", noteDTO);

        return "note";
    }
}
