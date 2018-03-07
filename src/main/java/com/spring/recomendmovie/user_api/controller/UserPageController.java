package com.spring.recomendmovie.user_api.controller;


import com.spring.recomendmovie.user_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/movie/user")
public class UserPageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userManage")
    public String userManage(Model model){
        model.addAttribute("users", userService.getAll());
        return "user/user_manage";
    }

    @RequestMapping("/home")
    public String user(Model model){
        model.addAttribute("user",userService.getUserById(new Long(1)));
        return "user/user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String registerPage(){
        return "register";
    }
}
