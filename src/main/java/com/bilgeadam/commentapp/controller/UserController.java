package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.repository.IUserRepository;
import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

@GetMapping("/orderbyname")
public ResponseEntity<List<User>> findAllUserByOrderByName(){

    return  ResponseEntity.ok( userService.findAllUserByOrderByName());
}

    @GetMapping("/containsname")
    public ResponseEntity<Optional<List<User>>> containsName(String value){
       return  ResponseEntity.ok(userService.containsName(value));
    }

    @GetMapping("/containsemail")
    public ResponseEntity<Optional<List<User>>> containsEmail(String value){
        return  ResponseEntity.ok(userService.containsEmaiil(value));
    }

    @GetMapping("/endwithemail")
    public ResponseEntity<Optional<List<User>>> endwithEmail(String value){
        return  ResponseEntity.ok(userService.endWithEmaiil(value));
    }


    @GetMapping("/login")
    public ResponseEntity<Optional<User>> login(String email,String password){
        return  ResponseEntity.ok(userService.login(email,password));
    }

    @GetMapping("/loginnativequery")
    public ResponseEntity<Optional<User>> loginNativeQuery(String email,String password){
        return  ResponseEntity.ok(userService.loginNativeQuery(email,password));
    }

    @GetMapping("/controlpasswordlength")
    public ResponseEntity< Optional<List<User>>> controlPasswordlength(int value){

        return ResponseEntity.ok(userService.controlPasswordlength(value));
    }
    @GetMapping("/controlpasswordlength2")
    public ResponseEntity< Optional<List<User>>> controlPasswordlength2(int value){

        return ResponseEntity.ok(userService.controlPasswordlength2(value));
    }
}
