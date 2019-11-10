package com.sust.community.service.impl;

import com.sust.community.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Supplier;

import static org.junit.Assert.*;

/**
 * Created by SunnyGrocery on 2019/10/15 21:17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByToken() {
        Assert.assertNull(userService.findByToken(""));
    }
}