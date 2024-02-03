package com.example.ticketsproject.domain.enums;

public enum TicketStatus {
    OPEN(1),
    PENDING(2),
    CLOSED_INCOMPLETE(3),
    CLOSED_COMPLETED(4);

    private int statusCode;

    private TicketStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getTicketStatusCode() {
        return statusCode;
    }

    public static TicketStatus valueOf(int statusCode) {
        for (TicketStatus value : TicketStatus.values()) {
            if (value.getTicketStatusCode() == statusCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TicketStatus code;");
    }
}