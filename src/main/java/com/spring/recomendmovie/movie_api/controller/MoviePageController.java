package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.comment_api.service.CommentService;
import com.spring.recomendmovie.movie_api.pojo.*;
import com.spring.recomendmovie.movie_api.service.MovieService;
import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.user_api.service.UserService;
import com.spring.recomendmovie.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/movie/movies")
public class MoviePageController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;


    @RequestMapping(value ="/updateMovie/{id}", method = RequestMethod.GET)
    public ModelAndView updateMoviePage(Model model, @PathVariable("id") Long id,HttpSession httpSession){
        if(httpSession.getAttribute("managerInfo")!=null) {
            ModelAndView modelAndView = new ModelAndView("movies/updatemovie");
            ArrayList<MovieType> movieTypes = movieService.getAllMovieType();
            Movie movie = movieService.getMovieById(id);
            modelAndView.addObject("movieTypes", movieTypes);
            modelAndView.addObject("movie", movie);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }
    }


    @RequestMapping ("/addMovieInfo")
    public ModelAndView addMovieInfoPage(Model model,HttpSession httpSession){
        if(httpSession.getAttribute("managerInfo")!=null) {
        ModelAndView modelAndView=new ModelAndView("movies/addmovie");
        ArrayList<MovieType> movieTypes = movieService.getAllMovieType();
        modelAndView.addObject("movieTypes",movieTypes);
        return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }
    }


    @Transactional(readOnly = false)
    @RequestMapping(value="/movieDetails/{id}/{currentPage}",method = RequestMethod.GET)
    public ModelAndView movieDetails(Model model, @PathVariable("id") Long id, @PathVariable("currentPage") int currentPage, HttpSession httpSession)
    {
//<<<<<<< HEAD
//
//            ModelAndView modelAndView = new ModelAndView("movies/movieDetail");
//            MovieDetail movieDetail = movieService.getMovieDetailById(id);
//            int pageSize = 7;
//            ArrayList<CommentDetail> commentDetails = commentService.getAllCommentsByMovie(id);
//            ArrayList<CommentDetail> commentDetails1 = commentService.getAllCommentsByMoviePage(id, currentPage, pageSize);
//            PageBean pageBean = new PageBean(currentPage, pageSize, commentDetails1, commentDetails.size());
//            int lenth = commentDetails.size();
//            modelAndView.addObject("count", lenth);
//            modelAndView.addObject("pageBean", pageBean);
//            modelAndView.addObject("movieDetail", movieDetail);
//            modelAndView.addObject("commentDetails", commentDetails1);
//            return modelAndView;
//=======
        ModelAndView modelAndView = new ModelAndView("movies/movieDetail");
        MovieDetail movieDetail = movieService.getMovieDetailById(id);
        User user = (User) httpSession.getAttribute("user");
        ArrayList<HistoryMovie> historyMovies = null;
        ArrayList<Movie> movies;
        if(user != null){
            Long user_id = user.getId();
            movies = movieService.getBrowseLog(user_id);
            modelAndView.addObject("movies", movies);
            //过渡user记录

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        comment.setComment_time(df.format(new Date()));
            BrowseLog browseLog = new BrowseLog(user.getId(), id, df.format(new Date()),movieDetail.getImage_url());
            historyMovies = movieService.selectTop5History(user_id);
            movieService.insertBrowseLog(browseLog);
        }

        int pageSize=7;
        ArrayList<CommentDetail> commentDetails = commentService.getAllCommentsByMovie(id);
        ArrayList<CommentDetail> commentDetails1 = commentService.getAllCommentsByMoviePage(id,currentPage,pageSize);
        PageBean pageBean = new PageBean(currentPage,pageSize,commentDetails1,commentDetails.size());
        int length = commentDetails.size();
        modelAndView.addObject("count",length);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("movieDetail",movieDetail);
        modelAndView.addObject("commentDetails",commentDetails1);
        modelAndView.addObject("historyMovie", historyMovies);
        return modelAndView;
//>>>>>>> 8a55993026804d33e96887c1d87d3d578c8d6107
    }

}
