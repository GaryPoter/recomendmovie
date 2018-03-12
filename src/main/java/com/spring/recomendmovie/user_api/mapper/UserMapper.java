package com.spring.recomendmovie.user_api.mapper;


import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.mapper.ObjMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


@Mapper // 为了让 UserMapper 能够被别的类进行引用
public interface UserMapper extends ObjMapper<User> {

//    @SelectProvider(type = DynaSqlProvider.class, method = "selectWithParam")
//    ArrayList<User> serchAll(Table table);
//
//    @Select("SELECT * FROM USER WHERE ID = #{id}")
//    User getUserById(@Param("id") Long id);
//
//    @Select("SELECT * FROM USER WHERE ID = #{id} OR NAME = #{name}")
//    User getUser(User user);
//
//    @Select("SELECT * FROM USER WHERE NAME = #{name} AND PASWD = #{paswd}")
//    User getUserByNameAndPaswd(User user);
//
//    @Insert("INSERT INTO USER(name, paswd) VALUES (#{name}, #{paswd})")
//    int addUser(User user);
////    @InsertProvider(type = DynaSqlProvider.class, method =  "insertWithParam")
////    int addUser(Table table);
//
//    @Delete("DELETE FROM USER WHERE ID = #{id}")
//    int deleteUser(User user);
////    @DeleteProvider(type = DynaSqlProvider.class, method = "deleteWithParam")
////    int deleteUser(Table table);
//
//    @Update("UPDATE USER SET name=#{name}, paswd=#{paswd} WHERE ID = #{id}")
//    int updateUser(User user);
//    @UpdateProvider(type = DynaSqlProvider.class, method = "updateWithParam")
//    int updateUser(Table table);
    @Select("select user.name , movie.name, comment.content from user, movie, comment where user.id = comment.user_id and movie.id = comment.movie_id")
    Object getAllComment();
    @Select("select * from user")
    User getAll();

    @SelectProvider(type = UserProvider.class, method = "loginWithEmail")
    User login(String email, String password);
}
