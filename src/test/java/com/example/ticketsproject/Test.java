package com.example.ticketsproject;

import com.example.ticketsproject.domain.Ticket;
import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.domain.enums.UserRegion;
import com.example.ticketsproject.domain.enums.TicketType;
import com.example.ticketsproject.repository.TicketRepository;
import com.example.ticketsproject.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@DisplayName("System test")
public class Test {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;
    User user;
    Ticket ticket;

    @BeforeAll
    public void deleteAllUsersFromDB(){
        userRepository.deleteAll();
    }
    @BeforeEach
    public void createUserTest(){
        user = new User(null,"Joao Teste", "Joaoteste@gmail.com", UserRegion.BR, false);
        userRepository.save(user);
    }

    @DisplayName("Insert User")
    @org.junit.jupiter.api.Test
    public void insertUser(){
        User mariah = new User(null,"Mariah Test", "Mariahtest@gmail.com", UserRegion.EUA, true);
        userRepository.insert(mariah);

    }

/*    @org.junit.jupiter.api.Test
    @DisplayName("Create a ticket")
    public void CreateTicketTest(){
        ticket = new Ticket(null, "1234", user, TicketType.RQT, "Troubleshooting", "SAP is crashing", "blablabla");
        System.out.println(ticket);
    }*/


}
