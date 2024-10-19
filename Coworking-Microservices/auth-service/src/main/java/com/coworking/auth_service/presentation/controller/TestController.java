package com.coworking.auth_service.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String testApi() {
        return "Welcome to the Auth Service xd!";
    }
}
