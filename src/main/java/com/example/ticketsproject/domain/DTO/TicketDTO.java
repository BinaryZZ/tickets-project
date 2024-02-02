package com.example.ticketsproject.domain.DTO;

import com.example.ticketsproject.domain.Ticket;
import com.example.ticketsproject.domain.User;

import java.time.Instant;

public class TicketDTO {

    private Long ticketId;
    private String createdDate;
    private String lastUpdate;
    private String number;
    private User user;
    private Integer ticketType;
    private String task;
    private String observation;
    private String note;

    public TicketDTO(){
    }

    public TicketDTO(Ticket ticket){
        ticketId = ticket.getTicketId();
        createdDate = ticket.getCreatedDate();
        lastUpdate = ticket.getLastUpdate();
        number = ticket.getNumber();
        user = ticket.getUser();
        ticketType = ticket.getTicketType().getTicketCode();
        task = ticket.getTask();
        observation = ticket.getObservation();
        note = ticket.getNote();

    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTicketType() {
        return ticketType;
    }

    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
