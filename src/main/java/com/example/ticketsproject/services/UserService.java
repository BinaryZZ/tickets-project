package com.example.ticketsproject.services;

import com.example.ticketsproject.domain.DTO.UserDTO;
import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.repository.UserRepository;
import com.example.ticketsproject.services.exception.ObjectNotFoundException;
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
        return user.orElseThrow(() -> new ObjectNotFoundException("User was not found!"));
    }

    public User insert (User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public void update(User user, UserDTO userDTO){
        updateData(user, userDTO);
        userRepository.save(user);
    }

    private void updateData(User user, UserDTO userDTO){
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRegion(userDTO.getRegion());
        user.setUserLevel(userDTO.getUserLevel());
    }

    public User fromDTO(UserDTO userDTO){
        return (new User(userDTO.getUserId(), userDTO.getName(), userDTO.getEmail(), userDTO.getRegion(), userDTO.getUserLevel()));
    }
}
