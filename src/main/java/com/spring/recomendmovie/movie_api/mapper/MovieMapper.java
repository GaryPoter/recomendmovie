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



    @Select("select * from movielens where type = 4 order by id limit 1,6")
    ArrayList<Movie> getSixMovies();

    @Select("select * from movielens where type = 4 order by rating desc limit 1,4")
    ArrayList<Movie> getFourMovies();

    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,format(rating,1) as rating,type1.type from movielens,type1 where movielens.type=type1.id and movielens.id=#{id}")
    MovieDetail getMovieDetailById(Long id);

//    @Select("select distinct(movielens.id),movie_name,download_url,image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,type1 " +
//            "where movielens.type=type1.id and ((movie_name like (CONCAT('%',#{searchInfo},'%'))) " +
//            "or (director like (CONCAT('%',#{searchInfo},'%')))) or (star like CONCAT('%',#{searchInfo},'%'))" +
//            "order by movielens.id desc limit #{firstRec},#{pageSize}")
    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,rating,type1.type from movielens,type1 " +
            "where movielens.type=type1.id and movie_name like (CONCAT('%',#{searchInfo},'%')) order by rating desc limit #{firstRec},#{pageSize}")
    ArrayList<MovieDetail> searchMovieByMovieNamePage(@Param("searchInfo") String movieName,@Param("firstRec") Integer firstRec,@Param("pageSize") int pageSize);

    @Select("select * from manager where mName=#{mName} and mPassword=#{mPassword}")
    ManagerInfo login(@Param("mName") String mName,@Param("mPassword") String mPassword);


    @Select("select * from movielens,recommendedmovies where movielens.id=movie_id and user_id=#{userID} order by movielens.rating limit 1,6")
//    @Select("select * from movielens,recommendedmovies where movielens.id=movie_id and user_id=#{userID} order by rating desc limit 1,4")
    ArrayList<Movie> getTopTenMovies(@Param("userID") Long id);

    @Select("select * from movielens,recommendedmovies where movielens.id=movie_id and user_id=#{userID} order by movielens.rating limit 1,4")
//    @Select("select * from movielens,recommendedmovies where movielens.id=movie_id and user_id=#{userID} order by rating desc limit 1,4")
    ArrayList<Movie> getTopTenMovies4(@Param("userID") Long id);

    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,format(rating,1) as rating,type1.type from movielens,recommendedmovies,type1 where movielens.id=movie_id and movielens.type = type1.id  and user_id=#{userID} order by rating desc")
    ArrayList<MovieDetail> recommendMoviesForUser(Integer userID);



    @Select("select * from movielens where type = 12 order by id limit 1,6")
    ArrayList<Movie> getSixMoviesx();

//    @Select("select * from movielens where type = 21 order by id limit 1,4")
//    ArrayList<Movie> getFourMoviesk();
    @Select("select * from movielens where type = 21 order by id limit 1,6")
    ArrayList<Movie> getSixMoviesk();


    @Select("select * from movielens where type = 12 order by rating desc limit 1,4")
    ArrayList<Movie> getFourMoviesx();

    @Select("select * from movielens where type = 21 order by rating desc limit 1,4")
    ArrayList<Movie> getFourMoviesk();


    @Select("select distinct(id),movie_name,download_url,movielens.image_url,director,star,area,duration,type,time,rating,mabstract from browselog,movielens where movie_id=id and user_id=#{id} order by id limit 1,4")
    ArrayList<Movie> getAllLookingMoviesByUId(@Param("id") Long id);

    @Select("select distinct(movielens.id),movie_name,download_url,movielens.image_url,director,star,duration,time,mabstract,format(rating,1) as rating,type1.type from movielens,browselog,type1 where movielens.id=movie_id and movielens.type = type1.id  and user_id=#{userID}")
    ArrayList<MovieDetail> browsingHistory(@Param("userID") Integer userID);

    @Insert("insert into browselog (user_id,movie_id,browsetime,image_url) values (#{user_id},#{movie_id}, #{browsetime},#{image_url})")
    int insertBrowseLog(BrowseLog browseLog);

    @Select("select movielens.movie_name,movielens.image_url from browselog, movielens,user where user_id=#{user_id} and browselog.user_id=user.id and browselog.movie_id=movielens.id ")
    ArrayList<Movie> getBrowseLog(@Param("user_id") Long user_id);

    @Select("select distinct(movielens.movie_name), browselog.browsetime, browselog.movie_id,movielens.image_url from movielens, browselog  where movielens.id = browselog.movie_id and browselog.user_id = #{user_id} order by browsetime desc limit 5")
    ArrayList<HistoryMovie> getTop5History(@Param("user_id") Long user_id);

    @Delete("delete from browselog where user_id= #{user_id}")
    int deleteBrowseLog(@Param("user_id") Long user_id, @Param("movie_id") Long movie_id);

    @Select("select movielens.* from movie_sim, movielens where movie_sim.movie_id1 = #{id} and movie_id2 = id")
    ArrayList<Movie> getSimMovies(Long id);

    @Update("update movielens set rating = rating+(#{newRating}-rating)/(count+1),count=count+1 where id=#{movieId}")
    boolean upadateRating(@Param("movieId") Long movieId, @Param("newRating") Double newRating);

    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,format(rating,1) as rating,type1.type from movielens,type1 where movielens.type = type1.id and movielens.type=#{type} order by rating desc ")
    ArrayList<MovieDetail> movieListByType(@Param("type") String type);

    @Select("select type from type1 where id=#{type}")
    String getType(@Param("type") Integer type);

    @Select("select movielens.id,movie_name,download_url,image_url,director,star,duration,time,mabstract,format(rating,1) as rating,type1.type from movielens,type1 where movielens.type = type1.id and movielens.type=#{type} order by rating desc limit #{firstRec},#{pageSize}")
    ArrayList<MovieDetail> movieListByTypePage(@Param("type") String type, @Param("firstRec") Integer firstRec,@Param("pageSize") int pageSize);

}
