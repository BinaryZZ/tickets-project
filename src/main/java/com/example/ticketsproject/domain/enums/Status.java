package com.example.ticketsproject.domain.enums;

public enum Status {
    OPEN(1),
    PENDING(2),
    CLOSED_INCOMPLETE(3),
    CLOSED_COMPLETED(4);

    private int statusCode;

    private Status(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getCode() {
        return statusCode;
    }

    public static Status valuOf(int statusCode) {
        for (Status value : Status.values()) {
            if (value.getCode() == statusCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status code;");
    }
}