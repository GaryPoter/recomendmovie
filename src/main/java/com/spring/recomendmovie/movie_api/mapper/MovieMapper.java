package com.spring.recomendmovie.movie_api.mapper;


import com.spring.recomendmovie.movie_api.pojo.*;

import com.spring.recomendmovie.user_api.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface MovieMapper {

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

<<<<<<< HEAD
    @Select("select distinct(id),movie_name,download_url,movielens.image_url,director,star,area,duration,type,time,rating,mabstract from browselog,movielens where movie_id=id and user_id=#{id} order by id limit 1,4")
    ArrayList<Movie> getAllLookingMoviesByUId(@Param("id") Long id);

    @Select("select distinct(movielens.id),movie_name,download_url,movielens.image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,browselog,type1 where movielens.id=movie_id and movielens.type = type1.id  and user_id=#{userID}")
    ArrayList<MovieDetail> browsingHistory(@Param("userID") Integer userID);
=======
    @Insert("insert into browselog (user_id,movie_id,browsetime,image_url) values (#{user_id},#{movie_id}, #{browsetime},#{image_url})")
    int insertBrowseLog(BrowseLog browseLog);

    @Select("select movie1.movie_name,movie1.image_url from browselog, movie1,user where user_id=#{user_id} and browselog.user_id=user.id and browselog.movie_id=movie1.id ")
    ArrayList<Movie> getBrowseLog(@Param("user_id") Long user_id);

    @Select("select distinct(movie1.movie_name), browselog.browsetime, browselog.movie_id,movie1.image_url from movie1, browselog  where movie1.id = browselog.movie_id and browselog.user_id = #{user_id} order by browsetime desc limit 5")
    ArrayList<HistoryMovie> getTop5History(@Param("user_id") Long user_id);

    @Delete("delete from browselog where user_id= #{user_id}")
    int deleteBrowseLog(@Param("user_id") Long user_id, @Param("movie_id") Long movie_id);
>>>>>>> 8a55993026804d33e96887c1d87d3d578c8d6107
}
