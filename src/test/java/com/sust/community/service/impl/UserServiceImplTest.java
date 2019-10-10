package com.sust.community.service.impl;

import com.sust.community.mapper.UserMapper;
import com.sust.community.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by SunnyGrocery on 2019/10/10 9:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void findByToken() {
        System.out.println(userService.findByToken("1"));
    }
}