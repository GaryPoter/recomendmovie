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
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping(value = "/movie/comment", method = RequestMethod.POST)
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/insert")
    public Result insert(Comment comment, HttpSession httpSession) {
        Result result = new Result();
        if (httpSession.getAttribute("user") == null) {
            result.setCode(Result.NOT_LOGIN_CODE);
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            comment.setComment_time(df.format(new Date()));
            if (commentService.insertComment(comment) != 0) {
                result.setCode(Result.SUCCESS_CODE);
            } else {
                result.setCode(Result.FAIL_CODE);
            }
        }
        return result;
    }
}



