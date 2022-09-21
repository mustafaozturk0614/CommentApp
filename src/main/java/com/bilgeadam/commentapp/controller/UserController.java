package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

private  final UserService userService;


@GetMapping("/save")
public ResponseEntity<User> save(String name , String surName, String email,String telephone,String password){
    User user=userService.save(User.builder().name(name).surName(surName).
            telephone(telephone).email(email).password(password).build());
    return ResponseEntity.ok(user);

}

@GetMapping ("/findAll")
 public ResponseEntity<List<User>> findAll(){

    return ResponseEntity.ok(userService.findAll()) ;
}

}
