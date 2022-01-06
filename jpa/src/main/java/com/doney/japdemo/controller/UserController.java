package com.doney.japdemo.controller;

import com.doney.japdemo.entity.User;
import com.doney.japdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value ="user")
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

    @GetMapping("v1")
    @ResponseBody
    public String testUpdateEntity(){
        Optional<User> optional = userRepository.findById(1L);
        User user = optional.get();
        System.out.println(user);
        tmpSaveEntity(1L);

        System.out.println(user);
        return "ok";
    }

    /**
     * hibernate对象管理 在同一个session 中只有一个对象实例
     */
    private void tmpSaveEntity(Long id){
        User user = new User();
        user.setId(id);
        user.setName("ODL");
        userRepository.save(user);
    }

}
