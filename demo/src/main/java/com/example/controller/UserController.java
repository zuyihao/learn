package com.example.controller;

import com.example.dao.UserRepository;
import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserRepository userRepository ;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id")Long id){
        return userRepository.findById(id).orElse(null);
    }
    @PostMapping("/{id}")
    public String addUser(@PathVariable("id")Long id,@PathVariable User user){
        User r = userRepository.save(user);
        return r.toString();
    }
}
