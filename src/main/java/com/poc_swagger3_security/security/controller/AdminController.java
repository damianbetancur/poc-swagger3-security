package com.poc_swagger3_security.security.controller;

import com.poc_swagger3_security.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/numberOfUsers")
    public Integer getNumberOfUsers() {
        return userRepository.findAll().size();
    }


}
