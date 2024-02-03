package com.example.ticketsproject.domain.enums;

public enum TicketType {
    SRQ(1),
    RQT(2),
    CHT(3);

    private int ticketTypeCode;

    private TicketType(int ticketTypeCode) {
        this.ticketTypeCode = ticketTypeCode;
    }

    public int getTicketCode() {
        return ticketTypeCode;
    }

    public static TicketType valueOf(int ticketTypeCode) {
        for (TicketType value : TicketType.values()) {
            if (value.getTicketCode() == ticketTypeCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Ticket Type TicketType;");
    }
}