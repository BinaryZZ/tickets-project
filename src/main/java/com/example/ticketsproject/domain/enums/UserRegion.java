package com.example.ticketsproject.domain.enums;

public enum UserRegion {
    BR(1),
    EUA(2),
    PT(3),
    MX(4),
    AR(5);

    private int regionCode;

    private UserRegion(int regionCode) {
        this.regionCode = regionCode;
    }

    public int getRegionCode() {
        return regionCode;
    }

    public static UserRegion valueOf(int regionCode) {
        for (UserRegion value : UserRegion.values()) {
            if (value.getRegionCode() == regionCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid UserRegion Code!");

    }
}