package com.example.assets.controller;

import com.example.assets.dto.LoginRequest;
import com.example.assets.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
       Boolean response = authenticationService.login(loginRequest.getUserName() ,loginRequest.getPassword());
        if (response){
            return "Successfully  Logged in";
        }

        return "Login failed";    }

    @PostMapping("/logout")
    public String logout(@RequestParam String username){
        Boolean response = authenticationService.logout(username);
        if (response){
        return "Successfully  Logout";
        }
        return "Logout failed";
    }

}
