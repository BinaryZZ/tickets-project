package com.example.ticketsproject.resources;


import com.example.ticketsproject.domain.DTO.TicketDTO;
import com.example.ticketsproject.domain.Ticket;
import com.example.ticketsproject.services.SequenceService;
import com.example.ticketsproject.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {

    @Autowired
    private TicketService ticketService;


    @GetMapping
    public ResponseEntity<List<TicketDTO>> findAll(){
        List<Ticket> listTickets = ticketService.findAll();
        List<TicketDTO> listDTOTickets = listTickets.stream().map(x -> new TicketDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTOTickets);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketDTO> findById(@PathVariable String id){
        Ticket ticket = ticketService.findById(id);
        return ResponseEntity.ok().body(new TicketDTO(ticket));
    }

    public ResponseEntity<Void> insert(@RequestBody TicketDTO ticketDTO){
        Ticket ticket = ticketService.fromDTO(ticketDTO);
        ticket = ticketService.insert(ticket);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ticket.getTicketId()).toUri();
        return ResponseEntity.created(uri).build();
    }



}
