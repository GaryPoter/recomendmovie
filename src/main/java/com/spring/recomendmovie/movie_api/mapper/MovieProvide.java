package com.spring.recomendmovie.movie_api.mapper;

import com.spring.recomendmovie.movie_api.pojo.Movie;
import org.apache.ibatis.jdbc.SQL;


public class MovieProvide {

    public String getMovieByLikeName(String likeName){
        return new SQL(){
            {
                SELECT("*");
                FROM(Movie.TABLENAME);
                WHERE(Movie.MOVIENAME + "like \'%" + likeName +"%\'");
            }
        }.toString();
    }
}
