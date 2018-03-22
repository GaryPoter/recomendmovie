package com.spring.recomendmovie.comment_api.controller;

import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.comment_api.service.CommentService;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.utils.PageBean;
import com.spring.recomendmovie.utils.message.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView searchComments(@RequestParam("searchContent") String userName, Model model){
        return  searchCommentsBy(1,userName,model);
    }

    @RequestMapping(value="/search/{searchContent}/{current_page}",method = RequestMethod.GET)
    public ModelAndView searchCommentsBy(@PathVariable("current_page") Integer currentPage, @PathVariable("searchContent") String uName, Model model){
        int pageSize = 20;
        ArrayList<CommentDetail> commentDetails1 = commentService.searchCommentByUName(uName);
        ArrayList<CommentDetail> commentDetails = commentService.searchCommentByUNamePage(uName,currentPage,pageSize);
        ModelAndView modelAndView = new ModelAndView("comment/searchCommentTByUName");
        PageBean pageBean = new PageBean(currentPage,pageSize,commentDetails,commentDetails1.size());
        int lenth = commentDetails1.size();
        modelAndView.addObject("count",lenth);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("commentDetails",commentDetails);
        modelAndView.addObject("searchContent",uName);
        return modelAndView;
    }
}



