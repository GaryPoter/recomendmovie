package com.spring.recomendmovie.user_api.mapper;


import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;


@Mapper // 为了让 UserMapper 能够被别的类进行引用
public interface UserMapper{

    @Select("select user.name , movie.name, comment.content from user, movie, comment where user.id = comment.user_id and movie.id = comment.movie_id")
    Object getAllComment();

    @Select("select * from user")
    ArrayList<User> getAll();

    @SelectProvider(type = UserProvider.class, method = "loginWithEmail")
    User login(String email, String password);

    @DeleteProvider(type = UserProvider.class, method = "deleteUser")
    int deleteUser(User user);

    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    int updateUser(User user);

    @Select("select * from user where id =#{id}")
    User getUserById(@Param("id") Long id);



    @Select("select * from user where username like CONCAT('%',#{username},'%')")
    ArrayList<User> searchUserByLKUsername(@Param("username") String username);


    @Select("select * from user where email like CONCAT('%',#{email},'%')")
    ArrayList<User> searchUserByLKEmail(@Param("email") String username);

    @InsertProvider(type = UserProvider.class, method = "insertUser")
    int insertUser(User user);
}
