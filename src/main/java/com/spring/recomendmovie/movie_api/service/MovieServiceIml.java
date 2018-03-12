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
        //movieTable.clear();

        return movieMapper.getAllMovies();
    }

    @Override
    public ArrayList<MovieDetail> getAllMoviesBy(Integer currentPage) {
        //movieTable.clear();
        Integer firstRec=(currentPage-1)*10;
        Integer lastRec=currentPage*10;
        return movieMapper.getAllMoviesBy(firstRec,lastRec);
    }

//    @Override
//    @Transactional(readOnly = false)
//    public int addMovie(Movie movie) {
//        movieTable.clear();
//        setValue(movie);
//        setWhere(movie);
//
//        return movieMapper.addObjWithParams(movieTable);
//    }

    @Override
    @Transactional(readOnly = false)
    public boolean deleteMovie(int id) {
        movieTable.clear();
        return movieMapper.deleteMovie(id);
    }

//    @Override
//    @Transactional(readOnly = false)
//    public int alterMovie(Movie movie) {
//        movieTable.clear();
//        setValue(movie);
//        setWhere(movie);
//        return movieMapper.updateObjWirhParams(movieTable);
//    }

//    @Override
//    @Transactional(readOnly = false)
//    public int deleteMovies(List<Movie> movies) {
//        int count = 0;
//        for (Movie movie: movies
//             ) {
//            count += deleteMovie(movie);
//        }
//        return count;
//    }

    @Override
    public ArrayList<MovieDetail> searchMovieByMovieName(String movieName) {
        return movieMapper.getMovieByName(movieName);
    }

//    private void setValue(Movie movie){
//        movieTable.setK(new String[]{Movie.MOVIENAME,
//                Movie.MOVIERESOUCEURL, Movie.IMAGEID, Movie.CATEGORYID});
//        movieTable.setV(new String[]{movie.getMovie_name(),
//                movie.getMovie_resource_url(), movie.getImage_id().toString(),
//                movie.getCategory_id().toString()});
//    }
//
//    private void setWhere(Movie movie){
//        movieTable.setSearch_k(new String[]{Movie.ID});
//        movieTable.setSearch_v(new String[]{movie.getId().toString()});
//    }
    @Override
    @Transactional(readOnly = false)
    public boolean insertMovie(Movie movie){
//        ArrayList<MovieDetail> moviedetail = movieMapper.getMovieByName(movie.getMovie_name());
//        if(moviedetail!=null&&moviedetail.size()!=0) {
//            return false;
//        }
            return movieMapper.insertMovie(movie);
    }
    @Override
    @Transactional(readOnly = false)
    public boolean updateMovie(Movie movie){
//        ArrayList<MovieDetail> moviedetail = movieMapper.getMovieByName(movie.getMovie_name());
//        if(moviedetail!=null&&moviedetail.size()!=0) {
//            return false;
//        }
        return movieMapper.updateMovie(movie);
    }

    @Override
    public ArrayList<MovieType> getAllMovieType(){
        return movieMapper.getAllMovieType();
    }

    @Override
    public  Movie getMovieById(Long id){return movieMapper.getMovieById(id);}
}
