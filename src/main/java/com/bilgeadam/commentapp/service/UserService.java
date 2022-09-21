package com.bilgeadam.commentapp.service;

import com.bilgeadam.commentapp.repository.IUserRepository;
import com.bilgeadam.commentapp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
  private   IUserRepository userRepository;

  public  User save(User user){
      return userRepository.save(user);
  }

    public List<User> findAll() {

      return  userRepository.findAll();

    }
}
