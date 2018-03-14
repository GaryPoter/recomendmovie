package com.spring.recomendmovie.comment_api.service;



import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.user_api.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface CommentService {
    //获取所有评论
    @Transactional(readOnly = true)
    ArrayList<CommentDetail> getAllComments();

    //根据电影名查询该电影所有相关的评论
    @Transactional(readOnly = true)
    ArrayList<CommentDetail> getCommentsByMovieName(String movie_name);

    //根据用户名查询所有该用户所有的评论
    @Transactional(readOnly = true)
    ArrayList<CommentDetail> getCommentsByUserName(String username);

    //评论电影
//    @Transactional(readOnly = false)
//    int insertComment(CommentDetail commentDetail);

    @Transactional(readOnly = false)
    int insertComment(Comment comment);

    //给电影打分
    @Transactional(readOnly = false)
    int scoreOnMovie(Comment comment);

    //删除电影评价
    @Transactional(readOnly = false)
    int deleteComment(int comment_id);

    //删除电影评价 p操作
    @Transactional(readOnly = false)
    int deleteComments(ArrayList<Comment> comments);

//<<<<<<< 添加
    //更新评论操作
//    @Transactional(readOnly = false)
//    int updateComment(long comment_id);
    int updateComment(Comment comment);
//=======原来
    ArrayList<CommentDetail> getAllCommentsBy(Integer currentPage);
}
//>>>>>>>
