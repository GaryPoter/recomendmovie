package com.spring.recomendmovie.movie_api.controller;

<<<<<<< HEAD
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> origin/my

@Controller
@RequestMapping("/movie")
public class HomeController {
<<<<<<< HEAD
    @Autowired
    private MovieService movieService;

=======

//    @Autowired
//    private UserService userService;

//    @Autowired
//    private ItemService itemService;
>>>>>>> origin/my

    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
