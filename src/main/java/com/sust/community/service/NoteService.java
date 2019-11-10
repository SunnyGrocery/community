package com.sust.community.service;

import com.sust.community.model.Note;

import java.util.List;

/**
 * Created by SunnyGrocery on 2019/10/11 17:48
 */
public interface NoteService {
    void save(Note note);

    void remove(Integer id);

    void change(Note note);

    Note findById(Integer id);

    List<Note> findByUserId(Integer userId);

    List<Note> findPageByUserId(Integer userId, Integer pageNum, Integer pageSize);

    List<Note> findPage(Integer pageNum, Integer pageSize);

    List<Note> findAll();
}
