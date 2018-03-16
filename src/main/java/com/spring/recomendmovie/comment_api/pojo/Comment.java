package com.spring.recomendmovie.comment_api.pojo;


import javax.validation.constraints.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
    public static final String TABLENAME = "user_comment_movie";

    public static final String ID = "id";

    public static final String USERID = "user_id";

    public static final String MOVIEID = "movie_id";

    public static final String COMMENT = "comment";

    public static final String COMMENTTIME = "comment_time";

    public static final String SCORE = "score";

    public static final String CLICKCOUNT = "click_count";

    @NotNull
    private Long id;

    @NotNull
    private Long user_id;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private Long movie_id;

    @NotNull
    private String comment_time;

    private String comment;


    private Double score;

    private Integer click_count;

    public Long getUser_id() { return user_id; }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
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

    public Integer getClick_count() {
        return click_count;
    }

    public void setClick_count(Integer click_count) {
        this.click_count = click_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //jackson对象的转换需要默认构造函数
    public Comment() {
    }



    public Comment(Long user_id, Long movie_id, String comment, Double score) {
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.comment = comment;
        this.score = score;
    }
}
