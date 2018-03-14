package com.spring.recomendmovie.movie_api.service;


import com.spring.recomendmovie.movie_api.mapper.MovieMapper;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.pojo.MovieType;

import com.spring.recomendmovie.utils.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MovieServiceIml implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    private static Table movieTable = new Table(Movie.TABLENAME);


    @Override
    public ArrayList<MovieDetail> getAllMovies() {

        return movieMapper.getAllMovies();
    }

    @Override
    public ArrayList<MovieDetail> getAllMoviesBy(Integer currentPage) {
        Integer firstRec=(currentPage-1)*10;
        Integer lastRec=currentPage*10;
        return movieMapper.getAllMoviesBy(firstRec,lastRec);
    }
    @Override
    public ArrayList<MovieDetail> searchMovieByMovieNamePage(String movieName, Integer currentPage){
        Integer firstRec=(currentPage-1)*10;
        Integer lastRec=currentPage*10;
        return movieMapper.searchMovieByMovieNamePage(movieName,firstRec,lastRec);
    }



    @Override
    @Transactional(readOnly = false)
    public boolean deleteMovie(int id) {
        movieTable.clear();
        return movieMapper.deleteMovie(id);
    }



    @Override
    public ArrayList<MovieDetail> searchMovieByMovieName(String movieName) {
        return movieMapper.getMovieByName(movieName);
    }


    @Override
    @Transactional(readOnly = false)
    public boolean insertMovie(Movie movie){
            return movieMapper.insertMovie(movie);
    }
    @Override
    @Transactional(readOnly = false)
    public boolean updateMovie(Movie movie){
        return movieMapper.updateMovie(movie);
    }

    @Override
    public ArrayList<MovieType> getAllMovieType(){
        return movieMapper.getAllMovieType();
    }

    @Override
    public  Movie getMovieById(Long id){return movieMapper.getMovieById(id);}

    @Override
    public ArrayList<Movie> getFourMovies(){
        return movieMapper.getFourMovies();
    }

    @Override
    public MovieDetail getMovieDetailById(Long id){
        return movieMapper.getMovieDetailById(id);
    }
}
