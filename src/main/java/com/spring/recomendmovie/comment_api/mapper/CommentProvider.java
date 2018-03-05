package com.spring.recomendmovie.comment_api.mapper;
import groovy.time.BaseDuration;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

public class CommentProvider {
    public String getSelectStatementByUserId(Long id){
        return new SQL(){
            {
                SELECT("*");
                FROM("user_comment_movie");
                WHERE("user_id", id.toString());
            }
        }.toString();
    }
}
