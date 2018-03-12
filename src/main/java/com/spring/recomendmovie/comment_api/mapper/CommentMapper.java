package com.spring.recomendmovie.comment_api.mapper;


import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CommentMapper extends ObjMapper<Comment> {

    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie,user,user_comment_movie where movie.id=movie_id and user.id=user_id")
    ArrayList<CommentDetail> getAllComments();

    @Delete("delete from user_comment_movie where id =#{comment_id}")
    int deleteComment(@Param("comment_id") int comment_id);

    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie,user,user_comment_movie where movie.id=movie_id and user.id=user_id and movie_name=#{movie_name}")
    ArrayList<CommentDetail> getCommentsByMovieName(@Param("movie_name") String movie_name);

    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie,user,user_comment_movie where movie.id=movie_id and user.id=user_id and username=#{user_name}")
    ArrayList<CommentDetail> getCommentsByUserName(@Param("user_name") String user_name);

}
