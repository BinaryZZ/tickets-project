package com.example.ticketsproject.services;

import com.example.ticketsproject.domain.DTO.UserDTO;
import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("Object was not found"));
    }

    public User insert (User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user){
        User newUser = findById(user.getUserId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setRegion(user.getRegion());
        newUser.setUserLevel(user.getUserLevel());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getUserId(), userDTO.getName(), userDTO.getEmail(), userDTO.getRegion(), userDTO.getUserLevel());
    }
}
