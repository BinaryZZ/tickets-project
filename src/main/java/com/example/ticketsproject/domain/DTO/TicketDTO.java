package com.example.ticketsproject.domain.DTO;

import com.example.ticketsproject.domain.Ticket;
import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.domain.enums.TicketStatus;
import com.example.ticketsproject.domain.enums.TicketTask;
import com.example.ticketsproject.domain.enums.TicketType;

import java.time.Instant;

public class TicketDTO {

    private String ticketId;
    private String createdDate;
    private String lastUpdate;
    private Long number;
    private User user;
    private Integer ticketStatus;
    private Integer ticketType;
    private Integer task;
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
        ticketStatus = ticket.getTicketStatus().getTicketStatusCode();
        ticketType = ticket.getTicketType().getTicketCode();
        task = ticket.getTask().getTaskCode();
        observation = ticket.getObservation();
        note = ticket.getNote();

    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketType getTicketType() {
        return TicketType.valueOf(ticketType);
    }

    public void setTicketType(TicketType ticketType){
        if (ticketType != null) {
            this.ticketType = ticketType.getTicketCode();
        }
    }

    public TicketTask getTask() {
        return TicketTask.valueOf(task);
    }

    public void setTask(TicketTask task) {
        if (task != null){
            this.task = task.getTaskCode();
        }
    }

    public TicketStatus getTicketStatus() {
        return TicketStatus.valueOf(ticketStatus);
    }

    public void setTask(TicketStatus ticketStatus) {
        if (ticketStatus != null){
            this.ticketStatus = ticketStatus.getTicketStatusCode();
        }
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
