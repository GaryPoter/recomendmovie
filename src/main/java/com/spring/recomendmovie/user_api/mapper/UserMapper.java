package com.spring.recomendmovie.user_api.mapper;


import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


@Mapper // 为了让 UserMapper 能够被别的类进行引用
public interface UserMapper extends ObjMapper<User> {


    @Select("select user.name , movie.name, comment.content from user, movie, comment where user.id = comment.user_id and movie.id = comment.movie_id")
    Object getAllComment();
    @Select("select * from user")
    User getAll();

    @SelectProvider(type = UserProvider.class, method = "loginWithEmail")
    User login(String email, String password);
}
