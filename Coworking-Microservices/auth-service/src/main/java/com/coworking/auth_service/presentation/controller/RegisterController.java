package com.coworking.auth_service.presentation.controller;

import com.coworking.auth_service.presentation.dto.AuthRequest;
import com.coworking.auth_service.presentation.dto.UserDto;
import com.coworking.auth_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin("*")
@AllArgsConstructor
public class RegisterController {
    private  final UserService userService;
    @PostMapping("register")
    public ResponseEntity<String> FirstRegister(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
    }
    @PostMapping("login")
    public ResponseEntity<Map<String,String>> Login(@RequestBody AuthRequest authRequest){
        Map<String,String> message = userService.authenticateUser(authRequest);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PostMapping("register/oauth2/google")
    public ResponseEntity<Map<String,String>> googleRegister(@RequestBody Map<String, String> body) {
        Map<String,String> token=userService.generateTokenRegisterForGoogle(body.get("token"));
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }
    @PostMapping("login/oauth2/google")
    public ResponseEntity<Map<String,String>> googleLogin(@RequestBody Map<String, String> body) {
        Map<String,String> token=userService.generateTokenLoginForGoogle(body.get("token"));
        return new ResponseEntity<>(token, HttpStatus.OK);
    }


}
