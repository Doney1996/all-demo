package com.doney.japdemo.controller;

import com.doney.japdemo.entity.User;
import com.doney.japdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @ResponseBody
    public String save(){
        User user = new User();
        String name = UUID.randomUUID().toString().substring(1, 10);
        user.setName(name);
        userRepository.save(user);
        return user.getName();
    }

    @PostMapping
    @ResponseBody
    public String changeUser(){
        Optional<User> optional = userRepository.findById(1L);
        optional.ifPresent(user -> {
            String name = UUID.randomUUID().toString().substring(1, 10);
            user.setName(name);
            userRepository.save(user);
        });
       return "ok";
    }

}
