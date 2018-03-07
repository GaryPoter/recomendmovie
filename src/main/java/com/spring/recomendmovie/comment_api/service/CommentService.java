package com.spring.recomendmovie.comment_api.service;



import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.user_api.pojo.User;

import java.util.ArrayList;

public interface CommentService {
    //根据电影id得到所有的相关的评论
    ArrayList<Comment> getAllComment();

    //评论电影
    int commentOnMovie(Comment comment);

    //给电影打分
    int scoreOnMovie(Comment comment);

    //删除电影评价
    int deleteComment(Comment comment);

    //根据用户信息查询所有该用户评论的电影
    ArrayList<Movie> selectMoviesByUserId(User user);

    //删除电影评价 p操作
    int deleteComments(ArrayList<Comment> comments);
}
