package com.example.ticketsproject.repository;

import com.example.ticketsproject.domain.Sequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepository extends MongoRepository<Sequence, String> {
    Sequence findByid(String id);
}
