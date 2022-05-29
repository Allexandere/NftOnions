package com.rocket.onionnft.model.controller;

import com.rocket.onionnft.model.dto.ExternalUserDto;
import com.rocket.onionnft.model.exception.UserException;
import com.rocket.onionnft.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ExternalUserDto getUser(@PathVariable("userId") UUID userId) throws UserException {
        return userService.getUser(userId);
    }

    @PostMapping("")
    public ExternalUserDto createUser(@RequestBody ExternalUserDto externalUserDto) throws UserException {
        return userService.createUser(externalUserDto);
    }
}
