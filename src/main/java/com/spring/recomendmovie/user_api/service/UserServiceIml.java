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

    private static Result SUCCESS = new Result(Result.SUCCESS_CODE);

    private static Result FAIL = new Result(Result.FAIL_CODE);

    public UserServiceIml() {

    }

    /**
     * @param tableName 表名字
     * @return 一张新表
     */
    private Table getTable(String tableName){

        Table table = new Table(tableName);
        return table;
    }

    @Override
    public User getUserById(Long id){
//      return userMapper.getUserById(id);
        Table table = getTable(User.TABLENAME);
        table.setSearch_k(new String[]{User.ID});
        table.setSearch_v(new String[]{id.toString()});
        return userMapper.getObjWithParams(table).get(0);
    }

    @Override
    public User getUser(User user){
        Table table = getTable(User.TABLENAME);
        table.setSearch_k(new String[]{User.ID, User.NAME, User.EMAIL, User.PASSWORD});
        table.setSearch_v(new String[]{user.getId().toString(), user.getName(), user.getEmail(), user.getPassword()});
        return userMapper.getObjWithParams(table).get(0);
    }

    @Override
    public ArrayList<User> getAll(){
        Table table = new Table(User.TABLENAME);
        return userMapper.getObjWithParams(table);
    }

    @Override
    @Transactional(readOnly = false)
    public int addUser(User user){
        Table table = getTable(User.TABLENAME);
        table.setK(new String[]{User.NAME, User.EMAIL, User.PASSWORD});
        table.setV(new String[]{user.getName(),user.getEmail(), user.getPassword()});
        return userMapper.addObjWithParams(table);
    }

    @Override
    @Transactional(readOnly = false)
    public int addUsers(ArrayList<User> users){
        int count = 0;
        for(User user : users){
            count += (addUser(user));
        }
        return count;
    }


    @Override
    @Transactional(readOnly = false)
    public Result register(User user){
        Table table = getTable(User.TABLENAME);
        table.setK(new String[]{User.NAME, User.EMAIL, User.PASSWORD});
        table.setV(new String[]{user.getName(),user.getEmail(), user.getPassword()});
        table.setSearch_k(new String[]{User.EMAIL});
        table.setSearch_v(new String[]{user.getEmail()});
//        User userSearch = userMapper.getUser(user);
        ArrayList<User> userSearch = userMapper.getObjWithParams(table);
        if(null != userSearch && userSearch.size() != 0){
            //如果用户名存在
            return FAIL;
        }else{
            //插入用户
            int r = userMapper.addObjWithParams(table);
            if(1 != r){
                //插入失败
                return FAIL;
            }else {
                return SUCCESS;
            }
        }
    }

    @Override
    @Transactional(readOnly = false)
    public Result deleteUser(User user) {
        Table table = new Table(User.TABLENAME);
        table.setK(new String[]{User.ID});
        table.setV(new String[]{user.getId().toString()});
        if (0 != userMapper.deleteObjWithParams(table)) {
            return SUCCESS;
        } else {
            return FAIL;
        }
    }

    @Override
    public User login(User user) {
//        User result = userMapper.login(user.getEmail(), user.getPassword());
        return userMapper.login(user.getEmail(), user.getPassword());
    }

}
