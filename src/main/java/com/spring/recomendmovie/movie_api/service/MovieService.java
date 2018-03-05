package com.spring.recomendmovie.movie_api.service;


import com.spring.recomendmovie.movie_api.pojo.Movie;

import java.util.ArrayList;
import java.util.List;

public interface MovieService {
    //获取所有的电影列表
    ArrayList<Movie> getAll();

    //添加电影
    int addMovie(Movie movie);

    //删除电影
    int deleteMovie(Movie movie);

    //修改电影
    int alterMovie(Movie movie);

    //删除勾选的电影 p操作
    int deleteMovies(List<Movie> movies);
}
