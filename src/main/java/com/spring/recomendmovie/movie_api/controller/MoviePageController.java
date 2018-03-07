package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.movie_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/movie/movies")
public class MoviePageController {
    @Autowired
    private MovieService movieService;

    @RequestMapping("/movieManager")
    public String toMovieManager(){
        return "movies/movie_manager";
    }

    @RequestMapping("/addMovie")
    public String addMoviePage(){
        return "movies/movie_insert";
    }

    @RequestMapping(value ="/updateMovie/{id}", method = RequestMethod.GET)
    public String updateMoviePage(){ return "movies/movie_update";}

    @RequestMapping("/movieManage")
    public String movieManagePage(){
        return "movies/movietable";
    }
}
