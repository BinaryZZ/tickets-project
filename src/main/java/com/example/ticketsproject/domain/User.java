package com.example.ticketsproject.domain;

import com.example.ticketsproject.domain.enums.UserRegion;
import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    @Serial
    private static final long SerialVersionUID = 1L;

    @Id
    private String userId;

    private String name;
    private String email;
    private Integer region;
    private Boolean userLevel = false;

    public User() {
    }

    public User(String userId, String name, String email, UserRegion region, Boolean userLevel) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        setRegion(region);
        this.userLevel = userLevel;
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

    public Boolean getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Boolean userLevel) {
        this.userLevel = userLevel;
    }

    public UserRegion getRegion() {
        if (region != null) {
            return UserRegion.valueOf(region);
        } else {
            return null;
        }
    }

    public void setRegion(UserRegion region) {
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


