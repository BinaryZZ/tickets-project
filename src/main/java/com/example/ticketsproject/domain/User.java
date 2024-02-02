package com.example.ticketsproject.domain;
import com.example.ticketsproject.domain.enums.Region;

import java.util.Objects;

public class User {

    private Long userId;
    private String name;
    private String email;
    private Integer region;
    private Boolean userLevel = false;

    public User(){
    }

    public User(Long userId, String name, String email, Region region, Boolean userLevel) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        setRegion(region);
        this.userLevel = userLevel;
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

    public Boolean getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Boolean userLevel) {
        this.userLevel = userLevel;
    }

    public Region getRegion(){
        return Region.valueOf(region);
    }

    public void setRegion(Region region){
        if (region != null) {
            this.region = region.getRegionCode();
        }
    }

    @Override
    public String toString() {
        String userLevelString = (userLevel) ? "VIP" : "Common";
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", region=" + region +
                ", user level=" + userLevelString +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User users)) return false;
        return Objects.equals(getUserId(), users.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}


