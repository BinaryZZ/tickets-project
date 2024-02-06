package com.example.ticketsproject.domain.DTO;

import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.domain.enums.UserRegion;

public class UserDTO {
    private String userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public UserRegion getRegion() {
        if (region != null){
            return UserRegion.valueOf(region);
        } else {
            return null;
        }
    }

    public void setRegion(UserRegion region){
        if (region != null) {
            this.region = region.getRegionCode();
        }
    }

    public Boolean getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Boolean userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", region=" + region +
                ", userLevel=" + userLevel +
                '}';
    }
}
