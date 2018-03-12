package com.spring.recomendmovie.user_api.mapper;

import com.spring.recomendmovie.user_api.pojo.User;
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
}
