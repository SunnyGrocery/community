package com.sust.community.model;

import com.sust.community.dto.UserDTO;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by SunnyGrocery on 2019/10/8 10:37
 */
@Data
public class User {
    public static User fromUserDTOAndGenUUID(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAccountId(userDTO.getId());
        user.setToken(UUID.randomUUID().toString());
        user.setBio(userDTO.getBio());
        return user;
    }

    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private String bio;
    private Date createTime;
    private Date modifiedTime;

}
