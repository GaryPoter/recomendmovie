package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.movie_api.pojo.ManagerInfo;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.pojo.MovieType;
import com.spring.recomendmovie.movie_api.service.MovieService;
import com.spring.recomendmovie.utils.PageBean;
import com.spring.recomendmovie.utils.message.Result;
import com.sun.deploy.net.HttpResponse;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
@RequestMapping("/movie/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchMovie(@RequestParam("searchContent") String movieName,Model model,HttpSession httpSession){
        if(httpSession.getAttribute("managerInfo")!=null) {
            return searchMovieBy(1, movieName, model);
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }
    }

    @RequestMapping(value="/search/{searchContent}/{current_page}",method = RequestMethod.GET)
    public ModelAndView searchMovieBy(@PathVariable("current_page") Integer currentPage,@PathVariable("searchContent") String movieName,Model model){
        int pageSize = 20;
        ArrayList<MovieDetail> movieDetails1 = movieService.searchMovieByMovieName(movieName);
        ArrayList<MovieDetail> movieDetails = movieService.searchMovieByMovieNamePage(movieName,currentPage,pageSize);
        ModelAndView modelAndView = new ModelAndView("movies/searchMovieTable");
        PageBean pageBean = new PageBean(currentPage,pageSize,movieDetails,movieDetails1.size());
        int lenth = movieDetails1.size();
        modelAndView.addObject("count",lenth);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("movies",movieDetails);
        modelAndView.addObject("searchContent",movieName);
        return modelAndView;
    }

    @RequestMapping(value="/batchDelete/{chestr}",method=RequestMethod.GET)
    public ModelAndView batchDelete(@PathVariable("chestr") String chestr,Model model,HttpSession httpSession){
        if(httpSession.getAttribute("managerInfo")!=null) {
            String[] strArr = null;
            strArr = chestr.split(",");
            for (int i = 0; i < strArr.length; i++) {
                int movieId = Integer.parseInt(strArr[i]);
                movieService.deleteMovie(movieId);
            }
            return getAllMovies(model, httpSession);
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }
    }

    @RequestMapping(value="/delete/{movie_id}",method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("movie_id") int id,Model model,HttpSession httpSession){
        if(httpSession.getAttribute("managerInfo")!=null) {
            movieService.deleteMovie(id);

            return getAllMovies(model, httpSession);
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }

    }

    @RequestMapping("/getAllMovies")
    public ModelAndView getAllMovies(Model model,HttpSession httpSession){
        if(httpSession.getAttribute("managerInfo")!=null) {
            return getAllMoviesBy(1, model);
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/getAllMovies/{current_page}", method=RequestMethod.GET)
    public ModelAndView getAllMoviesBy(@PathVariable("current_page") Integer currentPage,Model model){
        int pageSize = 20;
        ArrayList<MovieDetail> movieDetails1 = movieService.getAllMovies();
        ArrayList<MovieDetail> movieDetails = movieService.getAllMoviesBy(currentPage,pageSize);
        ModelAndView modelAndView = new ModelAndView("movies/movietable");
        PageBean pageBean = new PageBean(currentPage,pageSize,movieDetails,movieDetails1.size());
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
        int pageSize=5;
        ModelAndView modelAndView = new ModelAndView("movies/movieListByUser");
        ArrayList<MovieDetail> movieDetails = movieService.searchMovieByMovieName(searchContent);
        ArrayList<MovieDetail> movieDetails1 = movieService.searchMovieByMovieNamePage(searchContent,currentPage,pageSize);
        PageBean pageBean = new PageBean(currentPage,pageSize,movieDetails1,movieDetails.size());
        int lenth=movieDetails.size();
        modelAndView.addObject("count",lenth);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("movies",movieDetails1);
        modelAndView.addObject("searchContent",searchContent);
        return modelAndView;
    }


    @RequestMapping("/loginAction")
    public Result login(String mName, String mPassword, HttpSession session){
        ManagerInfo managerInfo = movieService.login(new ManagerInfo(new Long(-1),mName,mPassword));
        if(managerInfo==null){
            return new Result(Result.FAIL_CODE);
        }else{
            session.setAttribute("managerInfo", managerInfo);
            return new Result((Result.SUCCESS_CODE));
        }
    }

    @RequestMapping(value = "/moviesRecommendForUser/{userID}",method = RequestMethod.GET)
    public ModelAndView RecommendMoviesForUser(Model model,@PathVariable("userID") Integer userID){
        ModelAndView modelAndView = new ModelAndView("movies/recommendMovieForUser");
        ArrayList<MovieDetail> movieDetails1 = movieService.recommendMoviesForUser(userID);
        modelAndView.addObject("movies",movieDetails1);
        return modelAndView;

    }
    @RequestMapping(value="/moviesBrowsinghistory/{userId}",method = RequestMethod.GET)
    public ModelAndView BrowsingHistory(Model model,@PathVariable("userId") Integer userID){
        ModelAndView modelAndView = new ModelAndView("user/browsingHistory");
        ArrayList<MovieDetail> movieDetails = movieService.browsingHistory(userID);
        modelAndView.addObject("lookingMovies",movieDetails);
        return modelAndView;
    }
}
