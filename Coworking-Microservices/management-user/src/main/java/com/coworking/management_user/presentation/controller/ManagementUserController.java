package com.coworking.management_user.presentation.controller;

import com.coworking.management_user.presentation.dto.UserDto;
import com.coworking.management_user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/management")
@AllArgsConstructor
public class ManagementUserController {
    private final UserService userService;
    @GetMapping("{email}")
    public ResponseEntity<UserDto> getInfoUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String hello(){
        return "Hello World by Anthonymss !";
    }

}
