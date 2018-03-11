package com.spring.recomendmovie.user_api.service;


import com.spring.recomendmovie.user_api.mapper.UserMapper;
import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.Table;
import com.spring.recomendmovie.utils.message.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.ArrayList;

@Service
@Transactional(readOnly = true)
public class UserServiceIml implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int addUsers(ArrayList<User> users) {
        return 0;
    }

    @Override
    public User login(User user) {
//        User result = userMapper.login(user.getEmail(), user.getPassword());
        return userMapper.login(user.getEmail(), user.getPassword());
    }

    @Override
    public Result register(User user) {
        return null;
    }

    @Override
    public Result deleteUser(User user) {
        return null;
    }
}
