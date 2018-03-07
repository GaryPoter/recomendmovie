package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.service.MovieService;
import com.spring.recomendmovie.utils.message.Result;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
@RequestMapping("/movie/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/search/{movie_name}", method = RequestMethod.GET)
    public ArrayList<MovieDetail> searchMovie(@PathVariable("movie_name") String movieName){
        return movieService.searchMovieByMovieName(movieName);
    }

    @RequestMapping(value="/delete/{movie_id}",method=RequestMethod.GET)
    public ArrayList<MovieDetail> delete(@PathVariable("movie_id") int id){
        movieService.deleteMovie(id);
           // JOptionPane.showMessageDialog(null, "删除成功");

        return movieService.getAllMovies();

    }

    @RequestMapping("/getAllMovies")
    public ArrayList<MovieDetail> getAllMovies(){
        return movieService.getAllMovies();
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
}
