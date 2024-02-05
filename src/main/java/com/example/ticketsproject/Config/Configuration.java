package com.example.ticketsproject.Config;

import com.example.ticketsproject.domain.Sequence;
import com.example.ticketsproject.domain.Ticket;
import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.domain.enums.TicketStatus;
import com.example.ticketsproject.domain.enums.TicketTask;
import com.example.ticketsproject.domain.enums.TicketType;
import com.example.ticketsproject.domain.enums.UserRegion;
import com.example.ticketsproject.repository.SequenceRepository;
import com.example.ticketsproject.repository.TicketRepository;
import com.example.ticketsproject.repository.UserRepository;
import com.example.ticketsproject.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SequenceRepository sequenceRepository;

    @Autowired
    private SequenceService sequenceService;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        ticketRepository.deleteAll();
        sequenceRepository.deleteAll();
        Sequence sequence = new Sequence(null, 1L);
        sequenceRepository.save(sequence);
        List<User> users = Arrays.asList(
                new User(null,"Mariah Test", "Mariahtest@gmail.com", UserRegion.EUA, true),
                new User(null,"John Test", "Johntest@gmail.com", UserRegion.EUA, true)
        );

        userRepository.saveAll(users);

        Ticket srqExample = new Ticket(null, sequenceService.generateSequence("sequence"), users.get(0), TicketType.SRQ, TicketStatus.OPEN, TicketTask.INSTALLATION, "Observation example", "note example");
        Ticket srqExample2 = new Ticket(null, sequenceService.generateSequence("sequence"), users.get(1), TicketType.SRQ, TicketStatus.OPEN, TicketTask.INSTALLATION, "Observation example", "note example");
        ticketRepository.save(srqExample);
        ticketRepository.save(srqExample2);
    }
}
