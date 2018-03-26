package com.spring.recomendmovie.movie_api.service;


import com.spring.recomendmovie.movie_api.pojo.*;
import com.spring.recomendmovie.user_api.pojo.User;

import java.util.ArrayList;

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

//    ArrayList<Movie> getFourMovies();
    ArrayList<Movie> getSixMovies();

    MovieDetail getMovieDetailById(Long id);

    ArrayList<MovieDetail> searchMovieByMovieNamePage(String movieName, Integer currentPage,int pageSize);

    ManagerInfo login(ManagerInfo manager);

    ArrayList<Movie> getTopTenMovies(Long id);

    ArrayList<MovieDetail> recommendMoviesForUser(Integer userID);

//    ArrayList<Movie> getFourMoviesx();
    ArrayList<Movie> getSixMoviesx();

//    ArrayList<Movie> getFourMoviesk();
    ArrayList<Movie> getSixMoviesk();


    ArrayList<Movie> getAllLookingMoviesByUId(Long id);

    ArrayList<MovieDetail> browsingHistory(Integer userID);

    //得到浏览记录
    ArrayList<Movie> getBrowseLog(Long id);

    //插入浏览记录
    int insertBrowseLog(BrowseLog browseLog);

    //得到五条浏览记录
    ArrayList<HistoryMovie> selectTop5History(Long user_id);

    //删除浏览记录
    int deleteBrowseLog(Long user_id, Long movie_id);

    ArrayList<Movie> getSimMovies(Long id);
}
