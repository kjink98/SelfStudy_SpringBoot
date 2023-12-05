package com.dogether.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogether.domain.User;
import com.dogether.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;
    
    @PostMapping("/signup")
    public String insert(User user) {
        boolean isResult = userService.insertUser(user);
        if (isResult) {
            return "redirect:/list";
        } else {
            return "redirect:/error";
        }
    }
}
