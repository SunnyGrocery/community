package com.sust.community.service.impl;

import com.sust.community.mapper.NoteMapper;
import com.sust.community.model.Note;
import com.sust.community.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SunnyGrocery on 2019/10/11 17:51
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public void save(Note note) {
        noteMapper.insert(note);
    }

    @Override
    public void remove(Integer id) {
        noteMapper.delete(id);
    }

    @Override
    public void change(Note note) {
        noteMapper.update(note);
    }

    @Override
    public Note findById(Integer id) {
        return noteMapper.selectById(id);
    }

    @Override
    public List<Note> findByUserId(String userId) {
        return noteMapper.selectByUserId(userId);
    }
}
