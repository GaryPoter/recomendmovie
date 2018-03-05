package com.spring.recomendmovie.movie_api.service;


import com.spring.recomendmovie.movie_api.mapper.MovieMapper;
import com.spring.recomendmovie.movie_api.pojo.Movie;
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
    public ArrayList<Movie> getAll() {
        movieTable.clear();
        return movieMapper.getObjWithParams(movieTable);
    }

    @Override
    @Transactional(readOnly = false)
    public int addMovie(Movie movie) {
        movieTable.clear();
        setValue(movie);
        setWhere(movie);

        return movieMapper.addObjWithParams(movieTable);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteMovie(Movie movie) {
        movieTable.clear();
        setWhere(movie);
        return movieMapper.deleteObjWithParams(movieTable);
    }

    @Override
    @Transactional(readOnly = false)
    public int alterMovie(Movie movie) {
        movieTable.clear();
        setValue(movie);
        setWhere(movie);
        return movieMapper.updateObjWirhParams(movieTable);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteMovies(List<Movie> movies) {
        int count = 0;
        for (Movie movie: movies
             ) {
            count += deleteMovie(movie);
        }
        return count;
    }

    private void setValue(Movie movie){
        movieTable.setK(new String[]{Movie.MOVIENAME,
                Movie.MOVIERESOUCEURL, Movie.IMAGEID, Movie.CATEGORYID});
        movieTable.setV(new String[]{movie.getMovie_name(),
                movie.getMovie_resource_url(), movie.getImage_id().toString(),
                movie.getCategory_id().toString()});
    }

    private void setWhere(Movie movie){
        movieTable.setSearch_k(new String[]{Movie.ID});
        movieTable.setSearch_v(new String[]{movie.getId().toString()});
    }
}
