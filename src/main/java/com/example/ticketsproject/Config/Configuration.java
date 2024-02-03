package com.example.ticketsproject.Config;

import com.example.ticketsproject.domain.Ticket;
import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.domain.enums.TicketStatus;
import com.example.ticketsproject.domain.enums.TicketTask;
import com.example.ticketsproject.domain.enums.TicketType;
import com.example.ticketsproject.domain.enums.UserRegion;
import com.example.ticketsproject.repository.TicketRepository;
import com.example.ticketsproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.Instant;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        ticketRepository.deleteAll();
        User mariah = new User(null,"Mariah Test", "Mariahtest@gmail.com", UserRegion.EUA, true);
        userRepository.save(mariah);

        Ticket srqExample = new Ticket(null, "123456", mariah, TicketType.SRQ, TicketStatus.OPEN, TicketTask.INSTALLATION, "Observation example", "note example");
        ticketRepository.save(srqExample);
    }
}
