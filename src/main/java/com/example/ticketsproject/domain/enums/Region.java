package com.example.ticketsproject.domain.enums;

public enum Region {
    BR(1),
    EUA(2),
    PT(3),
    MX(4),
    AR(5);

    private int regionCode;

    private Region(int regionCode) {
        this.regionCode = regionCode;
    }

    public int getRegionCode() {
        return regionCode;
    }

    public static Region valueOf(int regionCode) {
        for (Region value : Region.values()) {
            if (value.getRegionCode() == regionCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Region Code!");

    }
}