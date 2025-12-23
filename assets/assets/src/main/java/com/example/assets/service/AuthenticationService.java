package com.example.assets.service;

import com.example.assets.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private static final Map<String, User> userMap = new HashMap<>();
    private static final Map<String, User> authenticatedUsers = new HashMap<>();

    public AuthenticationService (){
        userMap.put("user1",new User("user1","password123",false));
    }

    public Boolean login (String username , String password){
        User user = userMap.get(username);
        if (user != null && user.getPassword().equals(password)){
            user.setAuthenticated(true);
            authenticatedUsers.put(username,user);
            return true;
        }
        return false;
    }

    public Boolean logout(String username){
        if(authenticatedUsers.containsKey(username)){
            User user = authenticatedUsers.get(username);
            user.setAuthenticated((false));
            authenticatedUsers.remove(username);
            return true;
        }
        return false;
    }
}
