package com.spring.recomendmovie.movie_api.mapper;


import com.spring.recomendmovie.movie_api.pojo.*;

import com.spring.recomendmovie.user_api.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface MovieMapper {

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


    @Select("select * from movie1 where type=10 order by id limit 1,4")
    ArrayList<Movie> getFourMovies();

    @Select("select movie1.id,movie_name,download_url,image_url,director,star,area,duration,time,mabstract,rating,type.type from movie1,type where movie1.type=type.id and movie1.id=#{id}")
    MovieDetail getMovieDetailById(Long id);

    @Select("select movie1.id,movie_name,download_url,image_url,director,star,area,duration,time,mabstract,rating,type.type from movie1,type where movie1.type=type.id and movie_name like CONCAT('%',#{movie_name},'%') order by movie1.id desc limit #{firstRec},#{pageSize}")
    ArrayList<MovieDetail> searchMovieByMovieNamePage(@Param("movie_name") String movieName,@Param("firstRec") Integer firstRec,@Param("pageSize") int pageSize);

    @Select("select * from manager where mName=#{mName} and mPassword=#{mPassword}")
    ManagerInfo login(@Param("mName") String mName,@Param("mPassword") String mPassword);

    @Select("select * from movie1,TopTenOfPerson where movie1.id=movieID and userID=#{userID} order by id limit 5,4")
    ArrayList<Movie> getTopTenMovies(@Param("userID") Long id);

    @Select("select movie1.id,movie_name,download_url,image_url,director,star,area,duration,time,mabstract,rating,type.type from movie1,TopTenOfPerson,type where movie1.id=movieID and movie1.type=type.id  and userID=#{userID}")
    ArrayList<MovieDetail> recommendMoviesForUser(Integer userID);


    @Select("select * from movie1 where type=2 order by id limit 1,4")
    ArrayList<Movie> getFourMoviesx();

    @Select("select * from movie1 where type=9 order by id limit 8,4")
    ArrayList<Movie> getFourMoviesk();

    @Insert("insert into browselog (user_id,movie_id,browsetime,image_url) values (#{user_id},#{movie_id}, #{browsetime},#{image_url})")
    int insertBrowseLog(BrowseLog browseLog);

    @Select("select movie1.movie_name,movie1.image_url from browselog, movie1,user where user_id=#{user_id} and browselog.user_id=user.id and browselog.movie_id=movie1.id ")
    ArrayList<Movie> getBrowseLog(@Param("user_id") Long user_id);

    @Select("select distinct(movie1.movie_name), browselog.browsetime, browselog.movie_id,movie1.image_url from movie1, browselog  where movie1.id = browselog.movie_id and browselog.user_id = #{user_id} order by browsetime desc limit 5")
    ArrayList<HistoryMovie> getTop5History(@Param("user_id") Long user_id);

    @Delete("delete from browselog where user_id= #{user_id}")
    int deleteBrowseLog(@Param("user_id") Long user_id, @Param("movie_id") Long movie_id);
}
