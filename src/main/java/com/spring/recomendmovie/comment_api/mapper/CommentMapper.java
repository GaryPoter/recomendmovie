package com.spring.recomendmovie.comment_api.mapper;


import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface CommentMapper extends ObjMapper<Comment> {
    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie1,user,user_comment_movie where movie1.id=movie_id and user.id=user_id and user_comment_movie.id = #{user_comment_movie.id}")
    ArrayList<CommentDetail> getCommentById(@Param("comment_id") long comment_id);

    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie1,user,user_comment_movie where movie1.id=movie_id and user.id=user_id order by user_comment_movie.id desc")
    ArrayList<CommentDetail> getAllComments();

    @Delete("delete from user_comment_movie where id =#{comment_id}")
    int deleteComment(@Param("comment_id") long comment_id);

    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie1,user,user_comment_movie where movie1.id=movie_id and user.id=user_id and movie_name=#{movie_name} order by user_comment_movie.id desc")
    ArrayList<CommentDetail> getCommentsByMovieName(@Param("movie_name") String movie_name);

    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie1,user,user_comment_movie where movie1.id=movie_id and user.id=user_id and username=#{user_name} order by user_comment_movie.id desc")
    ArrayList<CommentDetail> getCommentsByUserName(@Param("user_name") String user_name);

    @Insert("insert into user_comment_movie(user_id,movie_id,comment,comment_time,score) values(#{user_id},#{movie_id},#{comment},#{comment_time},#{score})")
    int insertComment(Comment comment);

    @Update("update user_comment_movie set comment=#{comment}, comment_time=#{comment_time}, score=#{score} where user_id=#{user_id}")
    //int updateComment(@Param("comment_id") long comment_id, @Param("comment") String comment, @Param("comment_time") Date comment_time,);
    int updateComment(Comment comment);
//添加
    @Select("select user_comment_movie.id,username,movie_name,comment,comment_time,score from movie1,user,user_comment_movie where movie1.id=movie_id and user.id=user_id order by user_comment_movie.id desc limit #{firstRec},#{pageSize}")
    ArrayList<CommentDetail> getAllCommentsBy(@Param("firstRec") Integer firstRec,@Param("pageSize") int pageSize);

    @Select("select username,movie_name,comment,comment_time,score from movie1,user_comment_movie,user where movie1.id=movie_id and user.id=user_id and movie_id = #{id}")
    ArrayList<CommentDetail> getAllCommentsByMovies(@Param("id") Long id);

    @Select("select username,movie_name,comment,comment_time,score from movie1,user_comment_movie,user where movie1.id=movie_id and user.id=user_id and movie_id = #{id} order by user_comment_movie.id desc limit #{firstRec},#{pageSize}")
    ArrayList<CommentDetail> getAllCommentsByMoviePage(@Param("id") Long id,@Param("firstRec") int firstRec,@Param("pageSize") int pageSize);
//原来
}
