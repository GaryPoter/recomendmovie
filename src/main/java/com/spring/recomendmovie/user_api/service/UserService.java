package com.spring.recomendmovie.user_api.service;

import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.utils.message.Result;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;


public interface UserService {
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private ObjMapper<User> userObjMapper;
//
//    private static Result SUCCESS = new Result(Result.SUCCESS_CODE);
//
//    private static Result FAIL = new Result(Result.FAIL_CODE);
//
//    public UserService() {
//
//    }
//
//    public User getUserById(Long id){
//        return userMapper.getUserById(id);
//    }
//
//    public User getUser(User user){
//        return userMapper.getUser(user);
//    }
//
//    public ArrayList<User> getAll(){
//        Table table = new Table("USER");
////        table.setLike_k(new String[]{"name"});
////        table.setLike_v(new String[]{"何"});
////        ArrayList<User> result = objMapper.getAll(table);
////        return userMapper.serchAll(table);
//        return userObjMapper.getObjWithParams(table);
//    }
//
//    @Transactional(readOnly = false)
//    public int addUser(User user){
//        return userMapper.addUser(user);
//    }
//
//    @Transactional(readOnly = false)
//    public int addUsers(ArrayList<User> users){
//        int count = 0;
//        for(User user : users){
//            count += (addUser(user));
//        }
//        return count;
//    }
//
//    public Result login(User user){
//        //查找数据库中是否有user并返回userTmp
//        User userTmp = userMapper.getUserByNameAndPaswd(user);
//        if(null != userTmp){
//            return SUCCESS;
//        }else{
//            return FAIL;
//        }
//    }
//
//    @Transactional(readOnly = false)
//    public Result register(User user){
//        User userSearch = userMapper.getUser(user);
//        if(null != userSearch){
//            //如果用户名存在
//            return FAIL;
//        }else{
//            //插入用户
//            int r = userMapper.addUser(user);
//            if(1 != r){
//                //插入失败
//                return FAIL;
//            }else {
//                return SUCCESS;
//            }
//        }
//    }
//
//    @Transactional(readOnly = false)
//    public Result deleteUser(User user){
//        if(0 != userMapper.deleteUser(user)){
//            return SUCCESS;
//        }else {
//            return FAIL;
//        }
//    }

    User getUserById(Long id);

    User getUser(User user);

    ArrayList<User> getAll();

    @Transactional(readOnly = false)    //可读写
    int addUser(User user);

    @Transactional(readOnly = false)
    int addUsers(ArrayList<User> users);

    Result login(User user);

    @Transactional(readOnly = false)
    Result register(User user);

    @Transactional(readOnly = false)
    Result deleteUser(User user);
}
