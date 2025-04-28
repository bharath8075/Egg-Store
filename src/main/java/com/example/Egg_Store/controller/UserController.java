package com.example.Egg_Store.controller;

import com.example.Egg_Store.model.User;
import com.example.Egg_Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-controller")
    public String userMethod(){
        return "Both user and admin can acces this";
    }

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        System.out.println(user.getEmail() + user.getPassword());
        return ResponseEntity.ok(userService.userRegister(user));
    }

//    @GetMapping("/user-login")
//    public String userLogin()
}
