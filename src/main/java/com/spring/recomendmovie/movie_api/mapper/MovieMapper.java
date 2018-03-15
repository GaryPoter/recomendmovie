package com.spring.recomendmovie.movie_api.mapper;


import com.spring.recomendmovie.movie_api.pojo.ManagerInfo;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.pojo.MovieDetail;
import com.spring.recomendmovie.movie_api.pojo.MovieType;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Mapper
public interface MovieMapper extends ObjMapper<Movie> {

    @Select("select movie1.id,movie_name,download_url,image_url,director,star,area,duration,time,mabstract,rating,type.type from movie1,type where movie1.type=type.id and movie_name like CONCAT('%',#{movie_name},'%')")
    ArrayList<MovieDetail> getMovieByName(@Param("movie_name") String movieName);

    @SelectProvider(type = MovieProvide.class, method = "getMovieByLikeName")
    ArrayList<Movie> getMovieByLikeName(String likeName);

    @Select("select movie1.id,movie_name,download_url,image_url,director,star,area,duration,type.type,time,mabstract from movie1,type where movie1.type=type.id order by movie1.id desc")
    ArrayList<MovieDetail> getAllMovies();

//   @SelectProvider(type=MovieProvide.class,method="getMovieDetailLikeName")
//   ArrayList<MovieDetail> getMovieByName(String likeName);

    @Delete("delete from movie where id =#{movie_id}")
    boolean deleteMovie(@Param("movie_id") int id);

    @Insert("insert into movie1(movie_name,download_url,image_url,director,star,area,duration,type,time,mabstract) values(#{movie_name},#{download_url},#{image_url},#{director},#{star},#{area},#{duration},#{type},#{time},#{mabstract})")
    boolean insertMovie(Movie movie);

    @Update("update movie1 set movie_name=#{movie_name},download_url=#{download_url},image_url=#{image_url},director=#{director},star=#{star},area=#{area},duration=#{duration},type=#{type},time=#{time},mabstract=#{mabstract} where id=#{id}")
    boolean updateMovie(Movie movie);

    @Select("select * from type")
    ArrayList<MovieType> getAllMovieType();

    @Select("select * from movie1 where id=#{movie_id}")
    Movie getMovieById(Long id);

    @Select("select movie1.id,movie_name,download_url,image_url,director,star,area,duration,type.type from movie1,type where movie1.type=type.id order by movie1.id desc limit #{firstRec},#{pageSize}")
    ArrayList<MovieDetail> getAllMoviesBy(@Param("firstRec") Integer firstRec,@Param("pageSize") int pageSize);


    @Select("select * from movie1 order by id limit 1,4")
    ArrayList<Movie> getFourMovies();

    @Select("select movie1.id,movie_name,download_url,image_url,director,star,area,duration,time,mabstract,rating,type.type from movie1,type where movie1.type=type.id and movie1.id=#{id}")
    MovieDetail getMovieDetailById(Long id);

    @Select("select movie1.id,movie_name,download_url,image_url,director,star,area,duration,time,mabstract,rating,type.type from movie1,type where movie1.type=type.id and movie_name like CONCAT('%',#{movie_name},'%') order by movie1.id desc limit #{firstRec},#{pageSize}")
    ArrayList<MovieDetail> searchMovieByMovieNamePage(@Param("movie_name") String movieName,@Param("firstRec") Integer firstRec,@Param("pageSize") int pageSize);

    @Select("select * from manager where mName=#{mName} and mPassword=#{mPassword}")
    ManagerInfo login(@Param("mName") String mName,@Param("mPassword") String mPassword);
}
