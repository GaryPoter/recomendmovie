package com.spring.recomendmovie.comment_api.service;


import com.spring.recomendmovie.comment_api.mapper.CommentMapper;
import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.comment_api.pojo.CommentDetail;

import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service    //对应的是业务层Bean  在类前注释，将此类实例化
@Transactional(readOnly = true)
public class CommentServiceIml implements CommentService {

    @Autowired  // 在属性前配置，将属性对应的对象从工厂中取出并注入到该bean中
    private CommentMapper commentMapper;

    private Table commentTable = new Table(Comment.TABLENAME);

    @Override
    @Transactional(readOnly = true)
    public ArrayList<CommentDetail> getAllComments(){
        return commentMapper.getAllComments();
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteComment(int comment_id) {
        commentTable.clear();
        return commentMapper.deleteComment(comment_id);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<CommentDetail> getCommentsByMovieName(String movie_name) {
        return commentMapper.getCommentsByMovieName(movie_name);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<CommentDetail> getCommentsByUserName(String username) {
        return commentMapper.getCommentsByUserName(username);
    }

    @Override
    public int commentOnMovie(Comment comment) {
        return 0;
    }

//    @Override
//    @Transactional(readOnly = true)
//    public int commentOnMovie(Comment comment){
//        return commentMapper.commentOnMovie(comment);
//    }

    @Override
    public int scoreOnMovie(Comment comment) {
        return 0;
    }

    @Override
    public int deleteComments(ArrayList<Comment> comments) {
        return 0;
    }

//    @Override
//    @Transactional(readOnly = false)
//    public int commentOnMovie(Comment comment) {
//        commentTable.clear();
//        setValue(comment);
//        setWhere(comment);
//        ArrayList<Comment> tmp = commentMapper.getObjWithParams(commentTable);
//        if(tmp.size() != 0)
//            return commentMapper.addObjWithParams(commentTable);
//        else {
//            return 0;
//        }
//    }
//
//    /**
//     *
//     * @param comment 用户id，电影id
//     */
//    private void setWhere(Comment comment) {
//        commentTable.setSearch_k(new String[]{
//                Comment.USERID, Comment.MOVIEID
//        });
//        commentTable.setSearch_v(new String[]{
//                comment.getUser_id().toString(), comment.getMovie_id().toString()
//        });
//    }
//
//
//
//    /**
//     *
//     * @param comment 评论comment，打分score
//     */
//    private void setValue(Comment comment) {
//        commentTable.setK(new String[]{
//                Comment.COMMENT, Comment.SCORE, Comment.COMMENTTIME
//        });
//        commentTable.setV(new String[]{
//                comment.getComment(), comment.getScore().toString(),
//                comment.getComment_time().toString()
//        });
//
//    }
}
