package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class UserController {
    private final Environment env;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service on PORT " + env.getProperty("local.server.port");
    }

    @GetMapping("/welcome")
    public String welcome() {
        var message = env.getProperty("greeting.message");
        return message;
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody RequestUser user) {
        var mapper = new ModelMapper();
        var userDto = mapper.map(user, UserDto.class);

        var createdUser = userService.createUser(userDto);

        var responseUser = mapper.map(createdUser, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        var userList = userService.getUserByAll();

        var mapper = new ModelMapper();

        List<ResponseUser> result = new ArrayList<>();

        if (userList != null) {
            userList.forEach(u -> result.add(mapper.map(u, ResponseUser.class)));
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{}")
    public ResponseEntity<?> getUsers() {
        Iterable<UserEntity> userList = userService.getUserBy
    }

}
