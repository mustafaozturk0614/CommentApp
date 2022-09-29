package com.bilgeadam.commentapp.mvc;


import com.bilgeadam.commentapp.dto.request.LoginRequesDto;
import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginMvcController {

  private  final  UserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;

    }

    @PostMapping("/dologin")
    public ModelAndView doLogin(LoginRequesDto dto){
        ModelAndView modelAndView=new ModelAndView();
        Optional<User> user=userService.login(dto.getEmail(),dto.getPassword());

        if (user.isPresent()){

            modelAndView.setViewName("home");
        }else {
            modelAndView.setViewName("redirect:login");
        }

        return  modelAndView;

    }


}
