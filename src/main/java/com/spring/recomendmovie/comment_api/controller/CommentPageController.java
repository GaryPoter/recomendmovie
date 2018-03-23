package com.spring.recomendmovie.comment_api.controller;

import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.comment_api.service.CommentService;
import com.spring.recomendmovie.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/movie/comment", method = RequestMethod.GET)
public class CommentPageController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/getAllComments")
    public ModelAndView getAllComments(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("managerInfo")!=null) {
            return getAllCommentsBy(1, model);
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/manager/login");
            return modelAndView;
        }
    }


    @RequestMapping(value = "/getAllComments/{currentPage}",method = RequestMethod.GET)
    public ModelAndView getAllCommentsBy(@PathVariable("currentPage") Integer currentPage, Model model){
        int pageSize=20;
        ModelAndView modelAndView = new ModelAndView("comment/commenttable");
        ArrayList<CommentDetail> commentDetails1 = commentService.getAllComments();
        ArrayList<CommentDetail> commentDetails =commentService.getAllCommentsBy(currentPage,pageSize);
        PageBean pageBean = new PageBean(currentPage,pageSize,commentDetails,commentDetails1.size());
        int length = commentDetails1.size();
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("count",length);
        modelAndView.addObject("commentDetails",commentDetails);
        modelAndView.addObject("commentDetails1",commentDetails1);
        return modelAndView;
    }



    @RequestMapping(value="/delete/{comment_id}",method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("comment_id") int id, Model model,HttpSession httpSession){
        commentService.deleteComment(id);
        // JOptionPane.showMessageDialog(null, "删除成功");
        return getAllComments(model,httpSession);
    }


    @RequestMapping(value="/batchDelete/{chestr}",method=RequestMethod.GET)
    public ModelAndView batchDelete(@PathVariable("chestr") String chestr,Model model,HttpSession httpSession){
        String[] strArr = null;
        strArr=chestr.split(",");
        for(int i=0;i<strArr.length;i++){
            int id= Integer.parseInt(strArr[i]);
            commentService.deleteComment(id);
        }
        return getAllComments(model,httpSession);
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.GET)
    public ModelAndView updateCommentPage(Model model){
       // commentService.updateComment(comment);
        //return getAllComments(model);
        ModelAndView modelAndView = new ModelAndView("comment/updateComment");
        return modelAndView;
    }

    @RequestMapping(value = "rightPage", method = RequestMethod.GET)
    public String rightFragment(){
        return "fragment/right";
    }
}
