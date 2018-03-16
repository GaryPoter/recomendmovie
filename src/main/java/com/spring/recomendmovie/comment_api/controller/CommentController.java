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
import java.text.SimpleDateFormat;
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
import java.text.SimpleDateFormat;
=======
>>>>>>> 92db22d256a3e5ba03e91f311011c5ccd1bf8266
>>>>>>> 44afb6ab8a920ace2f477b3ca87a7381fdb22208
>>>>>>> fbc9d282db853ad6262e57f5a4434d106caa32f8
import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping(value = "/movie/comment", method = RequestMethod.POST)
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/insert")
<<<<<<< HEAD
    public Result insert(Comment comment, HttpSession httpSession) {
        Result result = new Result();
        if (httpSession.getAttribute("user") == null) {
=======
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
>>>>>>> fbc9d282db853ad6262e57f5a4434d106caa32f8
            result.setCode(Result.NOT_LOGIN);
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            comment.setComment_time(df.format(new Date()));
<<<<<<< HEAD
            if (commentService.insertComment(comment) != 0) {
                        result.setCode(Result.SUCCESS_CODE);
                    } else {
                        result.setCode(Result.FAIL_CODE);
                    }
                }
                return result;
=======
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
>>>>>>> fbc9d282db853ad6262e57f5a4434d106caa32f8
            }
        }



