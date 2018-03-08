package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieType;
import com.spring.recomendmovie.movie_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/movie/movies")
public class MoviePageController {
    @Autowired
    private MovieService movieService;

//    @RequestMapping("/movieManager")
//    public String toMovieManager(){
//        return "movies/movie_manager";
//    }

//    @RequestMapping("/addMovie")
//    public String addMoviePage(){
//        return "movies/movie_insert";
//    }

    @RequestMapping(value ="/updateMovie/{id}", method = RequestMethod.GET)
    public ModelAndView updateMoviePage(Model model, @PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("movies/updatemovie");
        ArrayList<MovieType> movieTypes = movieService.getAllMovieType();
        Movie movie=movieService.getMovieById(id);
        modelAndView.addObject("movieTypes",movieTypes);
        modelAndView.addObject("movie",movie);
        return modelAndView;
    }

//    @RequestMapping("/movieManage")
//    public String movieManagePage(){
//        return "movies/movietable";
//    }

    @RequestMapping ("/addMovieInfo")
    public ModelAndView addMovieInfoPage(Model model){
        ModelAndView modelAndView=new ModelAndView("movies/addmovie");
        ArrayList<MovieType> movieTypes = movieService.getAllMovieType();
        modelAndView.addObject("movieTypes",movieTypes);
        return modelAndView;
        }

}
