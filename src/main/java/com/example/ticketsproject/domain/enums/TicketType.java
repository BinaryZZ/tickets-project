package com.example.ticketsproject.domain.enums;

public enum TicketType {
    SRQ(1),
    RQT(2),
    CHT(3);

    private int ticketCode;

    private TicketType(int ticketCode) {
        this.ticketCode = ticketCode;
    }

    public int getTicketCode() {
        return ticketCode;
    }

    public static TicketType valueOf(int ticketCode) {
        for (TicketType value : TicketType.values()) {
            if (value.getTicketCode() == ticketCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Ticket Type TicketType;");
    }
}