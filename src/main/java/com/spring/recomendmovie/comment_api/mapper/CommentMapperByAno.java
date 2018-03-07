package com.spring.recomendmovie.comment_api.mapper;

import com.spring.recomendmovie.comment_api.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.ArrayList;

@Mapper
public interface CommentMapperByAno {
    //基于注解
    @Select("select * from comment where movie_id = #{movie_id}")
    ArrayList<Comment> getAllCommentByMovieId(@Param("movie_id") Long movie_id);

    //基于动态注解 type 类名， method 方法名，返回sql语句
    @SelectProvider(type = CommentProvider.class, method = "getSelectStatementByUserId")
    ArrayList<Comment> getCommentOfUser(Long userId);
}
