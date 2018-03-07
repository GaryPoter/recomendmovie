package com.spring.recomendmovie.movie_api.mapper;


import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Mapper
public interface MovieMapper extends ObjMapper<Movie> {
    @Select("select movie.id,movie_name,movie_resouse_url,image_url from image,movie where image_id=image.id and movie_name = #{movie_name}")
    ArrayList<MovieDetail> getMovieByName(@Param("movie_name") String movieName);

    @SelectProvider(type = MovieProvide.class, method = "getMovieByLikeName")
    ArrayList<Movie> getMovieByLikeName(String likeName);

    @Select("select movie.id,movie_name,movie_resouse_url,image_url from image,movie where image_id=image.id")
    ArrayList<MovieDetail> getAllMovies();

    @Delete("delete from movie where id =#{movie_id}")
    boolean deleteMovie(@Param("movie_id") int id);

    @Insert("insert into movie(movie_name,movie_resouse_url,image_id) values(#{movie_name},#{movie_resouse_url},#{image_id})")
    boolean insertMovie(Movie movie);

    @Update("update movie set movie_name=#{movie_name},movie_resouse_url=#{movie_resouse_url},image_id=#{image_id} where id=#{id}")
    boolean updateMovie(Movie movie);
}
