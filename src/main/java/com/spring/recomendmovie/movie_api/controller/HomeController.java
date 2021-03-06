package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
@RequestMapping("/movie")
public class HomeController {

    @Autowired
    private MovieService movieService;


    @RequestMapping("/home")
    public ModelAndView home(Model model){
        ModelAndView modelAndView = new ModelAndView("/index");
        ArrayList<Movie> movies = movieService.getFourMovies();
        modelAndView.addObject("movies",movies);
        return  modelAndView;
    }
    @RequestMapping("/manager")
    public String manager(){
        return "manager/main";
    }

    @RequestMapping("/managerLogin")
    public String managerLogin(){return "manager/login";}

}
