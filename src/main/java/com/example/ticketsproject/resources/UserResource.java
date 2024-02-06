package com.example.ticketsproject.resources;


import com.example.ticketsproject.domain.DTO.UserDTO;
import com.example.ticketsproject.domain.User;
import com.example.ticketsproject.services.UserService;
import com.example.ticketsproject.services.exception.ObjectNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> listUsers = userService.findAll();
        List<UserDTO> listDTOUsers = listUsers.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTOUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable @NotNull String id) {
        try {
            User user = userService.findById(id);
            return ResponseEntity.ok().body(new UserDTO(user));
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody @Valid UserDTO userDTO) {
        User user = userService.insert(userService.fromDTO(userDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        try {
            User user = userService.findById(id);
            userService.delete(user.getUserId());
            return ResponseEntity.noContent().build();
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable @NotNull String id, @RequestBody UserDTO userDTO) {
        try {
            User user = userService.findById(id);
            userService.update(user, userDTO);
            return ResponseEntity.ok(user);
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
