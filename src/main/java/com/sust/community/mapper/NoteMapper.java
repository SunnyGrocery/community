package com.sust.community.mapper;

import com.sust.community.model.Note;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SunnyGrocery on 2019/10/11 16:48
 */
@Repository
@Mapper
public interface NoteMapper {
    void insert(Note note);

    void delete(Integer id);

    void update(Note note);

    Note selectById(Integer id);

    List<Note> selectByUserId(Integer userId);

    List<Note> selectAll();
}
