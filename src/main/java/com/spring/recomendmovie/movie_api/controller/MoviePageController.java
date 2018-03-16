package com.spring.recomendmovie.movie_api.controller;

import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
<<<<<<< HEAD
import com.spring.recomendmovie.comment_api.service.CommentService;
=======
>>>>>>> 44afb6ab8a920ace2f477b3ca87a7381fdb22208
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.pojo.MovieType;
import com.spring.recomendmovie.movie_api.service.MovieService;
<<<<<<< HEAD
import com.spring.recomendmovie.utils.PageBean;
=======
import com.spring.recomendmovie.comment_api.service.CommentService;
>>>>>>> 44afb6ab8a920ace2f477b3ca87a7381fdb22208
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Comment;

@Controller
@RequestMapping("/movie/movies")
public class MoviePageController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private CommentService commentService;


    @RequestMapping(value ="/updateMovie/{id}", method = RequestMethod.GET)
    public ModelAndView updateMoviePage(Model model, @PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("movies/updatemovie");
        ArrayList<MovieType> movieTypes = movieService.getAllMovieType();
        Movie movie=movieService.getMovieById(id);
        modelAndView.addObject("movieTypes",movieTypes);
        modelAndView.addObject("movie",movie);
        return modelAndView;
    }


    @RequestMapping ("/addMovieInfo")
    public ModelAndView addMovieInfoPage(Model model){
        ModelAndView modelAndView=new ModelAndView("movies/addmovie");
        ArrayList<MovieType> movieTypes = movieService.getAllMovieType();
        modelAndView.addObject("movieTypes",movieTypes);
        return modelAndView;
    }


<<<<<<< HEAD
    @RequestMapping(value="/movieDetails/{id}/{currentPage}",method = RequestMethod.GET)
    public ModelAndView movieDetails(Model model,@PathVariable("id") Long id,@PathVariable("currentPage") int currentPage)
    {
        ModelAndView modelAndView = new ModelAndView("movies/movieDetail");
        MovieDetail movieDetail = movieService.getMovieDetailById(id);
        int pageSize=7;
        ArrayList<CommentDetail> commentDetails = commentService.getAllCommentsByMovie(id);
        ArrayList<CommentDetail> commentDetails1 = commentService.getAllCommentsByMoviePage(id,currentPage,pageSize);
        PageBean pageBean = new PageBean(currentPage,pageSize,commentDetails1,commentDetails.size());
        int lenth=commentDetails.size();
        modelAndView.addObject("count",lenth);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("movieDetail",movieDetail);
        modelAndView.addObject("commentDetails",commentDetails1);
=======
    @RequestMapping(value="/movieDetails/{id}",method = RequestMethod.GET)
    public ModelAndView movieDetails(Model model, @PathVariable("id") Long id)
    {
        ModelAndView modelAndView = new ModelAndView("movies/movieDetail");
        MovieDetail movieDetail = movieService.getMovieDetailById(id);
        ArrayList<CommentDetail> commentDetails = commentService.getCommentsByMovieId(id);
        modelAndView.addObject("movieDetail",movieDetail);
        modelAndView.addObject("comments", commentDetails);
>>>>>>> 44afb6ab8a920ace2f477b3ca87a7381fdb22208
        return modelAndView;
    }

}
