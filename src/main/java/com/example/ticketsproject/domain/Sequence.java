package com.example.ticketsproject.domain;

import org.springframework.data.annotation.Id;

public class Sequence {
    @Id
    private String id;
    private Long sequence;

    public Sequence() {
    }

    public Sequence(String id, Long sequence) {
        this.id = id;
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}
