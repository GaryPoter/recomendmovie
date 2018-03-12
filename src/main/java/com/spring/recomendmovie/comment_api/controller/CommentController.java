package com.spring.recomendmovie.comment_api.controller;

<<<<<<< HEAD
import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.comment_api.service.CommentService;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
=======
import com.spring.recomendmovie.comment_api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> origin/my

@RestController
@RequestMapping(value = "/movie/comment", method = RequestMethod.POST)
public class CommentController {
    @Autowired
    private CommentService commentService;
<<<<<<< HEAD

//    @RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
//    public ArrayList<CommentDetail> getAllComments(){
//        return commentService.getAllComments();
//    }

//    @RequestMapping("/getAllComments")
//    public ModelAndView getAllComments(Model model){
//        ModelAndView modelAndView = new ModelAndView("comments/commenttable");
//        ArrayList<CommentDetail> commentDetails = commentService.getAllComments();
//        int lenth = commentDetails.size();
//        modelAndView.addObject("count",lenth);
//        modelAndView.addObject("comments",commentDetails);
//        return modelAndView;
//    }
=======
>>>>>>> origin/my
}
