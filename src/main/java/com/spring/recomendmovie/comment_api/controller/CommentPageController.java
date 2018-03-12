package com.spring.recomendmovie.comment_api.controller;

<<<<<<< HEAD
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.comment_api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
=======
import com.spring.recomendmovie.comment_api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> origin/my

@Controller
@RequestMapping(value = "/movie/comment", method = RequestMethod.GET)
public class CommentPageController {
    @Autowired
    private CommentService commentService;
<<<<<<< HEAD

    @RequestMapping("/getAllComments")
    public ModelAndView getAllComments(Model model){
        ModelAndView modelAndView = new ModelAndView("comment/commenttable");
        ArrayList<CommentDetail> commentDetails = commentService.getAllComments();
        int lenth = commentDetails.size();
        modelAndView.addObject("count",lenth);
        modelAndView.addObject("commentDetails",commentDetails);
        return modelAndView;
    }



    @RequestMapping(value="/delete/{comment_id}",method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("comment_id") int id, Model model){
        commentService.deleteComment(id);
        // JOptionPane.showMessageDialog(null, "删除成功");
        return getAllComments(model);
    }

=======
>>>>>>> origin/my
}
