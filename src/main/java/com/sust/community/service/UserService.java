package com.sust.community.service;

import com.sust.community.model.User;

import java.util.List;

/**
 * Created by SunnyGrocery on 2019/10/8 13:10
 */
public interface UserService {
    void save(User user);

    void remove(Integer id);

    void change(User user);

    User findByToken(String token);

    User findById(Integer id);

    User findByAccountId(String accountId);
    List<User> findAll();

}
