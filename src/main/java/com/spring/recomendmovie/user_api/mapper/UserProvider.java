package com.spring.recomendmovie.user_api.mapper;

import com.spring.recomendmovie.user_api.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public String loginWithEmail(String email, String password){
        return new SQL(){
            {
                SELECT("*");
                FROM(User.TABLENAME);
                WHERE(User.EMAIL + " = '" +  email + "'");
                WHERE(User.PASSWORD + " = '" + password + "'");
            }
        }.toString();
    }



    public String deleteUser(User user){
        return new SQL(){
            {
                DELETE_FROM(User.TABLENAME);
                if(user.getId() != null){
                    WHERE("id = " + user.getId());
                }
            }
        }.toString();
    }

    public String updateUser(User user){
        return new SQL(){
            {
                UPDATE(User.TABLENAME);
                if(user.getEmail() != null){
                    SET(User.EMAIL + " = '" + user.getEmail() + "'");
                }
                SET(User.NAME + "= '" + user.getUsername() + "'",
                        User.PASSWORD + "= '" + user.getPassword() + "'");
            }
        }.toString();
    }

    public String searchUserByUsername(String username){
        return new SQL(){
            {
                SELECT("*");
                FROM(User.TABLENAME);
                WHERE(User.NAME + " like '%" + username + "%'");

            }
        }.toString();
    }


    public String searchUserByLKEmail(String email){
        return new SQL(){
            {
                SELECT("*");
                FROM(User.TABLENAME);
                WHERE(User.EMAIL + " like '%" + email + "%'");
            }
        }.toString();
    }

    public String insertUser(User user){
        return new SQL(){
            {
                INSERT_INTO(User.TABLENAME);
                VALUES("username",
                        "'" + user.getUsername() + "'");
                VALUES("email",
                        "'" + user.getEmail() + "'");
                VALUES("password",
                        "'" + user.getPassword() + "'");
            }
        }.toString();
    }
}
