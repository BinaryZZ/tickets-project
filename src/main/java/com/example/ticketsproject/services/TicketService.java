package com.example.ticketsproject.services;


import com.example.ticketsproject.domain.DTO.TicketDTO;
import com.example.ticketsproject.domain.Ticket;
import com.example.ticketsproject.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(String id){
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElseThrow(() -> new RuntimeException("Object was not found"));
    }

    public Ticket insert (Ticket ticker){
        return ticketRepository.insert(ticker);
    }

    public void delete(String id){
        findById(id);
        ticketRepository.deleteById(id);
    }

    public Ticket update(Ticket ticket){
        Ticket newTicket = findById(ticket.getTicketId());
        updateData(newTicket, ticket);
        return ticketRepository.save(newTicket);
    }

    private void updateData(Ticket newTicket, Ticket ticket){
        newTicket.setTicketId(ticket.getTicketId());
        newTicket.setCreatedDate(ticket.getCreatedDate());
        newTicket.setLastUpdate(ticket.getLastUpdate());
        newTicket.setNumber(ticket.getNumber());
        newTicket.setUser(ticket.getUser());
        newTicket.setTicketStatus(ticket.getTicketStatus());
        newTicket.setTicketType(ticket.getTicketType());
        newTicket.setTask(ticket.getTask());
        newTicket.setObservation(ticket.getObservation());
        newTicket.setNote(ticket.getNote());
    }

    public Ticket fromDTO(TicketDTO ticketDTO){
        return new Ticket(ticketDTO.getTicketId(), ticketDTO.getNumber(), ticketDTO.getUser(), ticketDTO.getTicketType(), ticketDTO.getTicketStatus(), ticketDTO.getTask(), ticketDTO.getObservation(), ticketDTO.getNote(), ticketDTO.getCreatedDate(), ticketDTO.getLastUpdate());
    }

}
