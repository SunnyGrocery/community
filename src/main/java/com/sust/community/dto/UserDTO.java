package com.sust.community.dto;

import com.sust.community.model.User;
import lombok.Data;

/**
 * Created by SunnyGrocery on 2019/10/6 15:08
 */
@Data
public class UserDTO {

    private String name;
    //accountId
    private String id;
    private String bio;

    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getAccountId());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
