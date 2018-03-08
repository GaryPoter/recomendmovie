package com.spring.recomendmovie.comment_api.mapper;


import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CommentMapper extends ObjMapper<Comment> {

    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie,user,user_comment_movie where movie.id=movie_id and user.id=user_id")
    ArrayList<CommentDetail> getAllComments();
}
