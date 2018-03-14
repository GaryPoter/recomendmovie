package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.pojo.MovieType;
import com.spring.recomendmovie.movie_api.service.MovieService;
import com.spring.recomendmovie.utils.PageBean;
import com.spring.recomendmovie.utils.message.Result;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
@RequestMapping("/movie/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchMovie(@RequestParam("searchContent") String movieName,Model model){
        return searchMovieBy(1,movieName,model);
    }

    @RequestMapping(value="/search/{searchContent}/{current_page}",method = RequestMethod.GET)
    public ModelAndView searchMovieBy(@PathVariable("current_page") Integer currentPage,@PathVariable("searchContent") String movieName,Model model){
        ArrayList<MovieDetail> movieDetails1 = movieService.searchMovieByMovieName(movieName);
        ArrayList<MovieDetail> movieDetails = movieService.searchMovieByMovieNamePage(movieName,currentPage);
        ModelAndView modelAndView = new ModelAndView("movies/searchMovieTable");
        PageBean pageBean = new PageBean(currentPage,10,movieDetails,movieDetails1.size());
        int lenth = movieDetails1.size();
        modelAndView.addObject("count",lenth);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("movies",movieDetails);
        modelAndView.addObject("searchContent",movieName);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{movie_id}",method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("movie_id") int id,Model model){
        movieService.deleteMovie(id);

        return getAllMovies(model);

    }

    @RequestMapping("/getAllMovies")
    public ModelAndView getAllMovies(Model model){
        return getAllMoviesBy(1,model);
    }

    @RequestMapping(value = "/getAllMovies/{current_page}", method=RequestMethod.GET)
    public ModelAndView getAllMoviesBy(@PathVariable("current_page") Integer currentPage,Model model){
        ArrayList<MovieDetail> movieDetails1 = movieService.getAllMovies();
        ArrayList<MovieDetail> movieDetails = movieService.getAllMoviesBy(currentPage);
        ModelAndView modelAndView = new ModelAndView("movies/movietable");
        PageBean pageBean = new PageBean(currentPage,10,movieDetails,movieDetails1.size());
        int lenth = movieDetails1.size();
        modelAndView.addObject("count",lenth);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("movies",movieDetails);
        return modelAndView;
    }

    @RequestMapping("/insert")
    public Result insertMovie(Movie movie){
        Result result = new Result();
        if(movieService.insertMovie(movie)){
            ArrayList<MovieDetail> movies = movieService.getAllMovies();
            result.setItem(movies);
            result.setCode(Result.SUCCESS_CODE);
        }else {
            result.setCode(Result.FAIL_CODE);
        }
        return result;
    }

    @RequestMapping("/update")
    public Result updateMovie(Movie movie){
        Result result = new Result();
        if(movieService.updateMovie(movie)){
            ArrayList<MovieDetail> movies = movieService.getAllMovies();
            result.setItem(movies);
            result.setCode(Result.SUCCESS_CODE);
        }else{
            result.setCode(Result.FAIL_CODE);

        }
        return result;
    }



    @RequestMapping(value = "/movieListByUser",method=RequestMethod.POST)
    public ModelAndView getMovieList(@RequestParam("searchContent") String searchContent,Model model){
        return getMovieListByUser(searchContent,1,model);
    }

    @RequestMapping(value = "/movieListByUser/{searchContent}/{currentPage}",method = RequestMethod.GET)
    public ModelAndView getMovieListByUser(@PathVariable("searchContent") String searchContent,@PathVariable("currentPage") Integer currentPage, Model model){
        ModelAndView modelAndView = new ModelAndView("movies/movieListByUser");
        ArrayList<MovieDetail> movieDetails = movieService.searchMovieByMovieName(searchContent);
        ArrayList<MovieDetail> movieDetails1 = movieService.searchMovieByMovieNamePage(searchContent,currentPage);
        PageBean pageBean = new PageBean(currentPage,5,movieDetails1,movieDetails.size());
        int lenth=movieDetails.size();
        modelAndView.addObject("count",lenth);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("movies",movieDetails1);
        modelAndView.addObject("searchContent",searchContent);
        return modelAndView;
    }


}
