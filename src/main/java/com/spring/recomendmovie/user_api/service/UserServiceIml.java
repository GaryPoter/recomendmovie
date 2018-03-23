package com.spring.recomendmovie.user_api.service;


import com.spring.recomendmovie.comment_api.mapper.CommentMapper;
import com.spring.recomendmovie.user_api.mapper.UserMapper;
import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.Table;
import com.spring.recomendmovie.utils.message.Result;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.security.auth.login.FailedLoginException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceIml implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;

    private static Result SUCCESS = new Result(Result.SUCCESS_CODE);

    private static Result FAIL = new Result(Result.FAIL_CODE);

    public UserServiceIml() {

    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return userMapper.getAll();
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
    @Transactional(readOnly = false)
    public Result register(User user) {
        Result result = new Result();
        ArrayList<User> r = userMapper.searchUserByLKEmail(user.getEmail());
        if(r != null && r.size() != 0){
            result.setCode(Result.haveUser);
        }else {
            int i = userMapper.insertUser(user);
            if(i != 0){
                result.setCode(Result.SUCCESS_CODE);
            }else{
                result.setCode(Result.FAIL_CODE);
            }
        }

        return result;
    }

    @Override
    @Transactional(readOnly = false)
    public Result deleteUser(User user) {
        Result result = new Result();
        int r = commentMapper.deleteComments(user.getId());

        if(userMapper.deleteUser(user) == 0){
            result.setCode(Result.FAIL_CODE);
        }else{
            result.setCode(Result.SUCCESS_CODE);
        }
        return result;
    }

    @Override
    @Transactional(readOnly = false)
    public Result updateUser(User user) {
        int b = userMapper.updateUser(user);
        Result result = new Result();
        if(b != 0){
            result.setCode(Result.SUCCESS_CODE);
        }else {
            result.setCode(Result.FAIL_CODE);
        }
        return result;
    }

    @Override
    public ArrayList<User> getUsersByLikeWord(String username) {
        ArrayList<User> result = new ArrayList<>();
        ArrayList<User> listByUsername = userMapper.searchUserByLKUsername(username);
        ArrayList<User> listByEmail = userMapper.searchUserByLKEmail(username);

        result.addAll(listByUsername);
        result.addAll(listByEmail);
        return result;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean deleteUserById(Long uId) {
        return userMapper.deleteUserById(uId);
    }

}
