package com.spring.recomendmovie.user_api.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.service.MovieService;
import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.user_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/movie/user")
public class UserPageController {
    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @PostMapping("/searchUser")
    public ModelAndView searchUser(String username){
        ModelAndView modelAndView = new ModelAndView("user/user_manage");
        List<User> list = userService.getUsersByLikeWord(username);
        modelAndView.addObject("pageInfo", getPageInfo(list, 1, 10));
        return modelAndView;
    }

    private PageInfo<User> getPageInfo(List<User> list, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @RequestMapping(value = "/userManage", method = RequestMethod.GET)
    public ModelAndView userManage(@RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize,HttpSession httpSession){

        if(httpSession.getAttribute("managerInfo")!=null) {
            ModelAndView modelAndView = new ModelAndView("user/user_manage");

        List<User> list = userService.getAll();
        modelAndView.addObject("pageInfo",getPageInfo(list, pageNum, pageSize));
        return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }
    }

    @GetMapping(value = "/updateUserPage")
    public ModelAndView userDetail(@RequestParam(value = "id") Long id,HttpSession httpSession){
        if(httpSession.getAttribute("managerInfo")!=null) {
            ModelAndView modelAndView = new ModelAndView("user/personalPage");
            User user = userService.getUserById(id);
            if (user != null) {
                modelAndView.addObject("user", user);
            } else {
                modelAndView.addObject("user", new User());
            }
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }
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
        ArrayList<Movie> movies = movieService.getSixMovies();
        modelAndView.addObject("movies",movies);
        return  modelAndView;
    }

}
