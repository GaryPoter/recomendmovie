package com.spring.recomendmovie.movie_api.service;


import com.spring.recomendmovie.movie_api.mapper.MovieMapper;
import com.spring.recomendmovie.movie_api.pojo.*;

import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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
    public ArrayList<MovieDetail> getAllMoviesBy(Integer currentPage,int pageSize) {
        Integer firstRec=(currentPage-1)*pageSize;
        return movieMapper.getAllMoviesBy(firstRec,pageSize);
    }
    @Override
    public ArrayList<MovieDetail> searchMovieByMovieNamePage(String movieName, Integer currentPage,int pageSize){
        Integer firstRec=(currentPage-1)*pageSize;

        return movieMapper.searchMovieByMovieNamePage(movieName,firstRec,pageSize);
    }

    @Override
    public ManagerInfo login(ManagerInfo managerInfo) {
        return movieMapper.login(managerInfo.getmName(),managerInfo.getmPassword());
    }

    @Override
    public ArrayList<Movie> getTopTenMovies(Long id) {
        return movieMapper.getTopTenMovies(id);
    }

    @Override
    public ArrayList<MovieDetail> recommendMoviesForUser(Integer userID) {
        return movieMapper.recommendMoviesForUser(userID);
    }

    @Override
    public ArrayList<Movie> getFourMoviesx() {
        return movieMapper.getFourMoviesx();
    }

    @Override
    public ArrayList<Movie> getFourMoviesk() {
        return movieMapper.getFourMoviesk();
    }

    @Override
<<<<<<< HEAD
    public ArrayList<Movie> getAllLookingMoviesByUId(Long id) {
        return movieMapper.getAllLookingMoviesByUId(id);
    }

    @Override
    public ArrayList<MovieDetail> browsingHistory(Integer userID) {
        return movieMapper.browsingHistory(userID);
=======
    public ArrayList<Movie> getBrowseLog(Long id) {
        return movieMapper.getBrowseLog(id);
    }

    @Override
    public int insertBrowseLog(BrowseLog browseLog) {
        return movieMapper.insertBrowseLog(browseLog);
    }

    @Override
    public ArrayList<HistoryMovie> selectTop5History(Long user_id) {
        return movieMapper.getTop5History(user_id);
    }

    @Override
    public int deleteBrowseLog(Long user_id, Long movie_id) {
        return movieMapper.deleteBrowseLog(user_id, movie_id);
>>>>>>> 8a55993026804d33e96887c1d87d3d578c8d6107
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
