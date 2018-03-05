package com.spring.recomendmovie.comment_api.service;


import com.spring.recomendmovie.comment_api.mapper.CommentMapper;
import com.spring.recomendmovie.comment_api.pojo.Comment;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(readOnly = true)
public class CommentServiceIml implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    private Table commentTable = new Table(Comment.TABLENAME);


    @Override
    public ArrayList<Comment> getAllComment() {
        commentTable.clear();
        return commentMapper.getObjWithParams(commentTable);
    }

    @Override
    @Transactional(readOnly = false)
    public int commentOnMovie(Comment comment) {
        commentTable.clear();
        setValue(comment);
        setWhere(comment);
        ArrayList<Comment> tmp = commentMapper.getObjWithParams(commentTable);
        if(tmp.size() != 0)
            return commentMapper.addObjWithParams(commentTable);
        else {
            return 0;
        }
    }


    /**
     *
     * @param comment 用户id，电影id
     */
    private void setWhere(Comment comment) {
        commentTable.setSearch_k(new String[]{
                Comment.USERID, Comment.MOVIEID
        });
        commentTable.setSearch_v(new String[]{
                comment.getUser_id().toString(), comment.getMovie_id().toString()
        });
    }

    /**
     *
     * @param comment 评论comment，打分score
     */
    private void setValue(Comment comment) {
        commentTable.setK(new String[]{
                Comment.COMMENT, Comment.SCORE, Comment.COMMENTTIME
        });
        commentTable.setV(new String[]{
                comment.getComment(), comment.getScore().toString(),
                comment.getComment_time().toString()
        });

    }

    @Override
    public int scoreOnMovie(Comment comment) {
        return 0;
    }

    @Override
    public int deleteComment(Comment comment) {
        return 0;
    }

    @Override
    public ArrayList<Movie> selectMoviesByUserId(User user) {
        return null;
    }

    @Override
    public int deleteComments(ArrayList<Comment> comments) {
        return 0;
    }
}
