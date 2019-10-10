package com.sust.community.dto;

import com.sust.community.model.User;

/**
 * Created by SunnyGrocery on 2019/10/6 15:08
 */
public class UserDTO {

    private String name;
    private String id;
    private String bio;

    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getAccountId());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "GithubUserDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
