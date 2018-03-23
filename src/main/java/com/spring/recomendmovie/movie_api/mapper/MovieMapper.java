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

//    @Select("select distinct(movielens.id),movie_name,download_url,image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,type1 " +
//            "where movielens.type=type1.id and ((movie_name like CONCAT('%',#{searchInfo},'%')) or (director like CONCAT('%',#{searchInfo},'%')) or (star like CONCAT('%',#{searchInfo},'%')))")
    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,type1 " +
            "where movielens.type=type1.id and (movie_name like CONCAT('%',#{searchInfo},'%'))")
    ArrayList<MovieDetail> getMovieByName(@Param("searchInfo") String searchInfo);

    @SelectProvider(type = MovieProvide.class, method = "getMovieByLikeName")
    ArrayList<Movie> getMovieByLikeName(String likeName);

    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,type1.type,time,mabstract from movielens,type1 where movielens.type=type1.id order by movielens.id desc")
    ArrayList<MovieDetail> getAllMovies();

//   @SelectProvider(type=MovieProvide.class,method="getMovieDetailLikeName")
//   ArrayList<MovieDetail> getMovieByName(String likeName);

    @Delete("delete from movielens where id =#{movie_id}")
    boolean deleteMovie(@Param("movie_id") int id);

    @Insert("insert into movielens(movie_name,download_url,image_url,director,star,area,duration,type,time,mabstract) values(#{movie_name},#{download_url},#{image_url},#{director},#{star},#{area},#{duration},#{type},#{time},#{mabstract})")
    boolean insertMovie(Movie movie);

    @Update("update movielens set movie_name=#{movie_name},download_url=#{download_url},image_url=#{image_url},director=#{director},star=#{star},area=#{area},duration=#{duration},type=#{type},time=#{time},mabstract=#{mabstract} where id=#{id}")
    boolean updateMovie(Movie movie);

    @Select("select * from type1")
    ArrayList<MovieType> getAllMovieType();

    @Select("select * from movielens where id=#{movie_id}")
    Movie getMovieById(Long id);

    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,type1.type from movielens,type1 where movielens.type=type1.id order by movielens.id desc limit #{firstRec},#{pageSize}")
    ArrayList<MovieDetail> getAllMoviesBy(@Param("firstRec") Integer firstRec,@Param("pageSize") int pageSize);


    @Select("select * from movielens where type = 4 order by id limit 1,4")
    ArrayList<Movie> getFourMovies();

    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,type1 where movielens.type=type1.id and movielens.id=#{id}")
    MovieDetail getMovieDetailById(Long id);

//    @Select("select distinct(movielens.id),movie_name,download_url,image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,type1 " +
//            "where movielens.type=type1.id and ((movie_name like (CONCAT('%',#{searchInfo},'%'))) " +
//            "or (director like (CONCAT('%',#{searchInfo},'%')))) or (star like CONCAT('%',#{searchInfo},'%'))" +
//            "order by movielens.id desc limit #{firstRec},#{pageSize}")
    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,type1 " +
            "where movielens.type=type1.id and movie_name like (CONCAT('%',#{searchInfo},'%')) order by movielens.id desc limit #{firstRec},#{pageSize}")
    ArrayList<MovieDetail> searchMovieByMovieNamePage(@Param("searchInfo") String movieName,@Param("firstRec") Integer firstRec,@Param("pageSize") int pageSize);

    @Select("select * from manager where mName=#{mName} and mPassword=#{mPassword}")
    ManagerInfo login(@Param("mName") String mName,@Param("mPassword") String mPassword);

    @Select("select * from movielens,TopTenOfPerson where movielens.id=movieID and userID=#{userID} order by id limit 1,4")
    ArrayList<Movie> getTopTenMovies(@Param("userID") Long id);

    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,TopTenOfPerson,type1 where movielens.id=movieID and movielens.type = type1.id  and userID=#{userID}")
    ArrayList<MovieDetail> recommendMoviesForUser(Integer userID);


    @Select("select * from movielens where type = 12 order by id limit 1,4")
    ArrayList<Movie> getFourMoviesx();

    @Select("select * from movielens where type = 21 order by id limit 1,4")
    ArrayList<Movie> getFourMoviesk();

    @Select("select distinct(id),movie_name,download_url,movielens.image_url,director,star,area,duration,type,time,rating,mabstract from browselog,movielens where movie_id=id and user_id=#{id} order by id limit 1,4")
    ArrayList<Movie> getAllLookingMoviesByUId(@Param("id") Long id);

    @Select("select distinct(movielens.id),movie_name,download_url,movielens.image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,browselog,type1 where movielens.id=movie_id and movielens.type = type1.id  and user_id=#{userID}")
    ArrayList<MovieDetail> browsingHistory(@Param("userID") Integer userID);
}
