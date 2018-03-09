package com.spring.recomendmovie.movie_api.service;


import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.pojo.MovieType;

import java.util.ArrayList;
import java.util.List;

public interface MovieService {
    //获取所有的电影列表
    ArrayList<MovieDetail> getAllMovies();
    //删除电影
    boolean deleteMovie(int id);

    //根据电影名搜素电影
    ArrayList<MovieDetail> searchMovieByMovieName(String movieName);

    //插入一条电影纪录
    boolean insertMovie(Movie movie);

    //更新某条电影记录
    boolean updateMovie(Movie movie);
//    //添加电影
//    int addMovie(Movie movie);
//

//
//    //修改电影
//    int alterMovie(Movie movie);

//    //删除勾选的电影 p操作
//    int deleteMovies(List<Movie> movies);


    //获取所有电影类型
    ArrayList<MovieType> getAllMovieType();

    //根据电影ID查询电影
    Movie getMovieById(Long id);

    ArrayList<MovieDetail> getAllMoviesBy(Integer currentPage);
}
