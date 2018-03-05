package com.spring.recomendmovie.movie_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class HomeController {

//    @Autowired
//    private UserService userService;

//    @Autowired
//    private ItemService itemService;

    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
