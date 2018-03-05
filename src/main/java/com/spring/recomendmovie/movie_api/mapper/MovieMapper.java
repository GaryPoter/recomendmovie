package com.spring.recomendmovie.movie_api.mapper;


import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieMapper extends ObjMapper<Movie> {
}
