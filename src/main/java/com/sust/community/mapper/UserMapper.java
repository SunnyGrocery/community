package com.sust.community.mapper;

import com.sust.community.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SunnyGrocery on 2019/10/8 10:33
 */
@Repository
@Mapper
public interface UserMapper {
    void insert(User user);

    void delete(Integer id);

    void update(User user);

    User selectToken(String token);

    User selectById(Integer id);

    User selectByAccountId(String accountId);

    List<User> selectAll();
}
