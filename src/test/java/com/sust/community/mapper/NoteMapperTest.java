package com.sust.community.mapper;

import com.sust.community.model.Note;
import com.sust.community.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by SunnyGrocery on 2019/10/23 21:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class NoteMapperTest {

    @Autowired
    NoteMapper noteMapper;

    @Test

    public void insert() {
        User user = new User();
        user.setId(1);
        for (int i = 50; i < 200; i++) {
            Note note = new Note();

            note.setUser(user);
            note.setTitle("title_" + i);
            note.setDescription("description_" + i);
            note.setLabel("label1|label2");
            noteMapper.insert(note);
        }

    }
}