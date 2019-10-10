package com.sust.community.service.impl;

import com.sust.community.mapper.UserMapper;
import com.sust.community.model.User;
import com.sust.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SunnyGrocery on 2019/10/8 11:21
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void remove(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public void change(User user) {
        userMapper.update(user);
    }

    @Override
    public User findByToken(String token) {
        return userMapper.selectToken(token);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User findByAccountId(String accountId) {
        return userMapper.selectByAccountId(accountId);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

}
