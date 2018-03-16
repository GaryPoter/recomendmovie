package com.spring.recomendmovie.comment_api.controller;

import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.comment_api.service.CommentService;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.utils.message.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import java.text.SimpleDateFormat;
=======
>>>>>>> 92db22d256a3e5ba03e91f311011c5ccd1bf8266
>>>>>>> 44afb6ab8a920ace2f477b3ca87a7381fdb22208
import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping(value = "/movie/comment", method = RequestMethod.POST)
public class CommentController {
    @Autowired
    private CommentService commentService;

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

    @RequestMapping("/insert")
    public Result insert(Comment comment, HttpSession httpSession){
        Result result =  new Result();
<<<<<<< HEAD
        if(httpSession.getAttribute("user") == null)
        {
            result.setCode(Result.NOT_LOGIN_CODE);
        }
        else {
            if (commentService.insertComment(comment) != 0){

=======
<<<<<<< HEAD
        if(httpSession.getAttribute("user") == null){
            result.setCode(Result.NOT_LOGIN);
        }
        else{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            comment.setComment_time(df.format(new Date()));
            if (commentService.insertComment(comment) != 0){

=======
        if(httpSession.getAttribute("user") == null)
        {
            result.setCode(Result.NOT_LOGIN_CODE);
        }
        else {
            if (commentService.insertComment(comment) != 0){

>>>>>>> 92db22d256a3e5ba03e91f311011c5ccd1bf8266
>>>>>>> 44afb6ab8a920ace2f477b3ca87a7381fdb22208
                result.setCode(Result.SUCCESS_CODE);
            }else{
                result.setCode(Result.FAIL_CODE);
            }
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Result update(Long comment_id){
        Result result = new Result();
        Comment comment = new Comment();
        comment.setId(comment_id);
        if (commentService.updateComment(comment) != 0){
            result.setCode(Result.SUCCESS_CODE);
        }else {
            result.setCode(Result.FAIL_CODE);
        }
        return result;
    }

}
