package com.example.ticketsproject.domain.DTO;

import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.domain.enums.Region;

public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private Integer region;
    private Boolean userLevel;

    public UserDTO(){
    }

    public UserDTO(User user){
        userId = user.getUserId();
        name = user.getName();
        email = user.getEmail();
        region = user.getRegion().getRegionCode();
        userLevel = user.getUserLevel();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Boolean getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Boolean userLevel) {
        this.userLevel = userLevel;
    }
}
