package com.example.ticketsproject.repository;

import com.example.ticketsproject.domain.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, Long> {
}
