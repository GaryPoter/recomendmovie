package com.spring.recomendmovie.user_api.controller;


import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.service.MovieService;
import com.spring.recomendmovie.user_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;
import java.util.ArrayList;


@Controller
@RequestMapping("/movie/user")
public class UserPageController {
    @Autowired
    private UserService userService;

    private MovieService movieService;
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

    @RequestMapping(value = "/logOut")
    public ModelAndView home(Model model,HttpSession httpSession){
        httpSession.setAttribute("user", null);
        ModelAndView modelAndView = new ModelAndView("/index");
        ArrayList<Movie> movies = movieService.getFourMovies();
        modelAndView.addObject("movies",movies);
        return  modelAndView;
    }
//    public String logOut(HttpSession httpSession){
//        httpSession.setAttribute("user", null);
//        return "index";
//    }
}
