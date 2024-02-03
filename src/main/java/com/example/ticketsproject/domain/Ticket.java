package com.example.ticketsproject.domain;

import com.example.ticketsproject.domain.enums.TicketStatus;
import com.example.ticketsproject.domain.enums.TicketTask;
import com.example.ticketsproject.domain.enums.TicketType;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ticket implements Serializable {
    @Serial
    private static final long SerialVersionUID = 1L;

    @Id
    private String ticketId;
    private String createdDate = dateToBrTimeZoneAndRemoveMilliSeconds(Instant.now());
    private String lastUpdate = dateToBrTimeZoneAndRemoveMilliSeconds(Instant.now());
    private String number;
    private User user;
    private Integer ticketStatus;
    private Integer ticketType;
    private Integer task;
    private String observation;
    private String note;

    public Ticket(){
    }

    public Ticket(String ticketId, String number, User user, TicketType ticketType, TicketStatus ticketStatus, TicketTask task, String observation, String note, String createdDate, String lastUpdate) {
        this.ticketId = ticketId;
        this.number = number;
        this.user = user;
        setTicketStatus(ticketStatus);
        setTicketType(ticketType);
        setTask(task);
        this.observation = observation;
        this.note = note;
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
    }

    public Ticket(String ticketId, String number, User user, TicketType ticketType, TicketStatus ticketStatus, TicketTask task, String observation, String note) {
        this.ticketId = ticketId;
        this.number = number;
        this.user = user;
        setTicketStatus(ticketStatus);
        setTicketType(ticketType);
        setTask(task);
        this.observation = observation;
        this.note = note;
    }

    public Ticket(String ticketId, String number, User user, TicketType ticketType, TicketStatus ticketStatus, TicketTask task, String observation, String note, String createdDate) {
        this.ticketId = ticketId;
        this.number = number;
        this.user = user;
        setTicketStatus(ticketStatus);
        setTicketType(ticketType);
        setTask(task);
        this.observation = observation;
        this.note = note;
        this.createdDate = createdDate;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
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

    public TicketTask getTask() {
        return TicketTask.valueOf(task);
    }

    public void setTask(TicketTask task) {
        if (task != null) {
            this.task = task.getTaskCode();
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

    public TicketType getTicketType() {
        return TicketType.valueOf(ticketType);
    }

    public void setTicketType(TicketType ticketType){
        if (ticketType != null) {
            this.ticketType = ticketType.getTicketCode();
        }
    }

    public TicketStatus getTicketStatus(){
        return TicketStatus.valueOf(ticketStatus);
    }

    public void setTicketStatus(TicketStatus ticketStatus){
        if (ticketStatus != null) {
            this.ticketStatus = ticketStatus.getTicketStatusCode();
        }
    }

    public String dateToBrTimeZoneAndRemoveMilliSeconds(Instant date){
        Instant createdDateTime = Instant.now();
        ZoneId newTimeZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime zonedDateTime = date.atZone(newTimeZone);
        Instant removeMilliSeconds = date.truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        return formatter.format(removeMilliSeconds.atZone(newTimeZone));
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", createdDate=" + createdDate +
                ", lastUpdate=" + lastUpdate +
                ", number='" + number + '\'' +
                ", user=" + user +
                ", ticketType=" + ticketType +
                ", task='" + task + '\'' +
                ", observation='" + observation + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(getTicketId(), ticket.getTicketId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicketId());
    }
}
