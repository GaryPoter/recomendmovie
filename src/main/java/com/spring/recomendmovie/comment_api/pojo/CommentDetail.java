package com.spring.recomendmovie.comment_api.pojo;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CommentDetail {

    @NotNull
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String movie_name;

    private String comment;

    @NotNull
    private String comment_time;

    @NotNull
    private Double score;

    private String image_url;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    //jackson对象的转换需要默认构造函数
    public CommentDetail() {
    }

    public CommentDetail(Long id, String user_name, String movie_name, String comment, String comment_time, Double score) {
        this.id = id;
        this.username = user_name;
        this.movie_name = movie_name;
        this.comment = comment;
        this.comment_time = comment_time;
        this.score = score;
    }

    public CommentDetail(Long id, String username, String movie_name, String comment, Double score) {
        this.id = id;
        this.username = username;
        this.movie_name = movie_name;
        this.comment = comment;
        this.score = score;
    }

    public CommentDetail(Long id, String username, String movie_name, String comment, String comment_time, Double score, String image_url) {
        this.id = id;
        this.username = username;
        this.movie_name = movie_name;
        this.comment = comment;
        this.comment_time = comment_time;
        this.score = score;
        this.image_url = image_url;
    }
}
