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
        //User newUser = findById(user.getUserId());
        updateData(user, userDTO);
        userRepository.save(user);
    }

    private void updateData(User user, UserDTO userDTO){
        if (userDTO.getName() != null) { user.setName(userDTO.getName());};
        if (userDTO.getEmail() != null) { user.setEmail(userDTO.getEmail());};
        if (userDTO.getRegion() != null) { user.setRegion(userDTO.getRegion());};
        if (userDTO.getUserLevel() != null) { user.setUserLevel(userDTO.getUserLevel());};
    }

    public User fromDTO(UserDTO userDTO){
        if (userDTO.getName() == null || userDTO.getEmail() == null || userDTO.getRegion() == null || userDTO.getUserLevel() == null){
            throw new ObjectNotFoundException("Some User value is missing");
        }
        return (new User(userDTO.getUserId(), userDTO.getName(), userDTO.getEmail(), userDTO.getRegion(), userDTO.getUserLevel()));
    }
}
