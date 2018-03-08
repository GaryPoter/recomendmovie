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
    ArrayList<Comment> getCommentsByMovieName(String movie_name);

    //根据用户名查询所有该用户评论的电影
    @Transactional(readOnly = true)
    ArrayList<Movie> getMoviesByUserName(String user_name);

    //评论电影
    @Transactional(readOnly = false)
    int commentOnMovie(Comment comment);

    //给电影打分
    @Transactional(readOnly = false)
    int scoreOnMovie(Comment comment);

    //删除电影评价
    @Transactional(readOnly = false)
    int deleteComment(Comment comment);

    //删除电影评价 p操作
    @Transactional(readOnly = false)
    int deleteComments(ArrayList<Comment> comments);
}
