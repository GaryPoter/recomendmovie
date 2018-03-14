package com.spring.recomendmovie.movie_api.mapper;


import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.pojo.MovieType;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Mapper
public interface MovieMapper extends ObjMapper<Movie> {

    @Select("select movie.id,movie_name,movie_resouse_url,image_url,director,starring,area,duration,type_name from movie,movietype where typeId=type_id and movie_name like CONCAT('%',#{movie_name},'%')")
    ArrayList<MovieDetail> getMovieByName(@Param("movie_name") String movieName);

    @SelectProvider(type = MovieProvide.class, method = "getMovieByLikeName")
    ArrayList<Movie> getMovieByLikeName(String likeName);

    @Select("select movie.id,movie_name,movie_resouse_url,image_url,director,starring,area,duration,type_name from movie,movietype where typeId=type_id order by movie.id desc")
    ArrayList<MovieDetail> getAllMovies();

//   @SelectProvider(type=MovieProvide.class,method="getMovieDetailLikeName")
//   ArrayList<MovieDetail> getMovieByName(String likeName);

    @Delete("delete from movie where id =#{movie_id}")
    boolean deleteMovie(@Param("movie_id") int id);

    @Insert("insert into movie(movie_name,movie_resouse_url,image_url,director,starring,area,duration,typeId) values(#{movie_name},#{movie_resouse_url},#{image_url},#{director},#{starring},#{area},#{duration},#{typeId})")
    boolean insertMovie(Movie movie);

    @Update("update movie set movie_name=#{movie_name},movie_resouse_url=#{movie_resouse_url},image_url=#{image_url},director=#{director},starring=#{starring},area=#{area},duration=#{duration},typeId=#{typeId} where id=#{id}")
    boolean updateMovie(Movie movie);

    @Select("select * from movietype")
    ArrayList<MovieType> getAllMovieType();

    @Select("select * from movie where id=#{movie_id}")
    Movie getMovieById(Long id);

    @Select("select movie.id,movie_name,movie_resouse_url,image_url,director,starring,area,duration,type_name from movie,movietype where typeId=type_id order by movie.id desc limit #{firstRec},#{lastRec}")
    ArrayList<MovieDetail> getAllMoviesBy(@Param("firstRec") Integer firstRec,@Param("lastRec") Integer lastRec);


    @Select("select * from movie order by id limit 1,4")
    ArrayList<Movie> getFourMovies();

    @Select("select movie.id,movie_name,movie_resouse_url,image_url,director,starring,area,duration,type_name from movie,movietype where typeId=type_id and movie.id=#{id}")
    MovieDetail getMovieDetailById(Long id);

    @Select("select movie.id,movie_name,movie_resouse_url,image_url,director,starring,area,duration,type_name from movie,movietype where typeId=type_id and movie_name like CONCAT('%',#{movie_name},'%') order by movie.id desc limit #{firstRec},#{lastRec}")
    ArrayList<MovieDetail> searchMovieByMovieNamePage(@Param("movie_name") String movieName,@Param("firstRec") Integer firstRec,@Param("lastRec") Integer lastRec);

//    @Select("select * from image")
//    ArrayList<>
}
