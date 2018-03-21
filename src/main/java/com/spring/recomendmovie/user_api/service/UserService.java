package com.spring.recomendmovie.user_api.service;

import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.message.Result;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


public interface UserService {

    User getUserById(Long id);

    User getUser(User user);

    ArrayList<User> getAll();


    @Transactional(readOnly = false)    //可读写
    int addUser(User user);

    @Transactional(readOnly = false)
    int addUsers(ArrayList<User> users);

    User login(User user);

    @Transactional(readOnly = false)
    Result register(User user);

    @Transactional(readOnly = false)
    Result deleteUser(User user);

    @Transactional(readOnly = false)
    Result updateUser(User user);

    List<User> getUsersByLikeWord(String username);

    @Transactional(readOnly = false)
    boolean deleteUserById(Long uId);
}
