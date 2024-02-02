package com.example.ticketsproject.repository;

import com.example.ticketsproject.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
