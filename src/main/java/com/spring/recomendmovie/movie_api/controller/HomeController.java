package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.service.MovieService;
import com.spring.recomendmovie.user_api.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.ArrayList;


@Controller
@RequestMapping("/movie")
public class HomeController {

    @Autowired
    private MovieService movieService;


    @RequestMapping("/home")
    public ModelAndView home(Model model, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("/index");
//        ArrayList<Movie> movies = movieService.getFourMovies();
        ArrayList<Movie> movies = movieService.getSixMovies();
        modelAndView.addObject("movies",movies);

//        ArrayList<Movie> moviesx = movieService.getFourMoviesx();
        ArrayList<Movie> moviesx = movieService.getSixMoviesx();
        modelAndView.addObject("moviesx",moviesx);

//        ArrayList<Movie> moviesk = movieService.getFourMoviesk();
        ArrayList<Movie> moviesk = movieService.getSixMoviesk();
        modelAndView.addObject("moviesk",moviesk);

        if(httpSession.getAttribute("user")!=null){
            User user= (User) httpSession.getAttribute("user");
            ArrayList<Movie> movies1 = movieService.getTopTenMovies(user.getId());
            modelAndView.addObject("movies1",movies1);
        }
        return  modelAndView;
    }
    @RequestMapping("/manager")
    public String manager(){
        return "manager/main";
    }

    @RequestMapping("/managerLogin")
    public String managerLogin(){return "manager/login";}

}
