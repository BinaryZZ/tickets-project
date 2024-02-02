package com.example.ticketsproject;

import com.example.ticketsproject.domain.Ticket;
import com.example.ticketsproject.domain.Users;
import com.example.ticketsproject.domain.enums.Region;
import com.example.ticketsproject.domain.enums.TicketType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("System test")
public class Test {

    Users user;
    Ticket ticket;

    @BeforeEach
    public void createUserTest(){
        user = new Users(null,"Joaozin", "Joaozindamotocicleta@gmail.com", Region.BR, false);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Create a ticket")
    public void CreateTicketTest(){
        ticket = new Ticket(null, "1234", user, TicketType.RQT, "Troubleshooting", "SAP is crashing", "blablabla");
        System.out.println(ticket);
    }


}