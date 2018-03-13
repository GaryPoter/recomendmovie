package com.spring.recomendmovie.movie_api.mapper;

import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieType;
import groovy.transform.ToString;
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

    public String getMovieDetailLikeName(String likeName){
        return new SQL(){
            {
            SELECT("movie.id","movie_name","movie_resouse_url","image_url","director","starring","area","duration","type_name");
            FROM(Movie.TABLENAME, MovieType.TABLENAME);
            WHERE(MovieType.TYPEID+"="+Movie.TYPEID1 +"and"+ Movie.MOVIENAME + "like \'%"+likeName+"%\'");
            }
        }.toString();
    }
}
