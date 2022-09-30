package com.bilgeadam.commentapp.mvc;


import com.bilgeadam.commentapp.dto.request.LoginRequesDto;
import com.bilgeadam.commentapp.repository.entity.EUserType;
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

  private final ProductMvcController productMvcController;

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

            if (user.get().getUserType().equals(EUserType.ADMIN)){
                modelAndView.addObject("userlist",userService.findAll());
                modelAndView.setViewName("admin");
//               return admin(); //postmappingle admin metodunu ?a??r?yoruz

            }else {
                modelAndView.addObject("userId",user.get().getId());
                modelAndView.setViewName("redirect:/productmvc/getallproducts");
//           return     productMvcController.getAllproducts(user.get());
            }

        }else {
            modelAndView.setViewName("redirect:login");
        }

        return  modelAndView;

    }

    @PostMapping("/admin")
    public  ModelAndView  admin(){
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("userlist",userService.findAll());
        modelAndView.setViewName("admin");
        return  modelAndView;
    }

}
