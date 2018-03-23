package com.spring.recomendmovie.movie_api.service;


import com.spring.recomendmovie.movie_api.pojo.ManagerInfo;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.pojo.MovieType;
import org.apache.catalina.Manager;

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

    //获取所有电影类型
    ArrayList<MovieType> getAllMovieType();

    //根据电影ID查询电影
    Movie getMovieById(Long id);

    ArrayList<MovieDetail> getAllMoviesBy(Integer currentPage,int pageSize);

    ArrayList<Movie> getFourMovies();

    MovieDetail getMovieDetailById(Long id);

    ArrayList<MovieDetail> searchMovieByMovieNamePage(String movieName, Integer currentPage,int pageSize);

    ManagerInfo login(ManagerInfo manager);

    ArrayList<Movie> getTopTenMovies(Long id);

    ArrayList<MovieDetail> recommendMoviesForUser(Integer userID);

    ArrayList<Movie> getFourMoviesx();

    ArrayList<Movie> getFourMoviesk();

    ArrayList<Movie> getAllLookingMoviesByUId(Long id);

    ArrayList<MovieDetail> browsingHistory(Integer userID);
}
