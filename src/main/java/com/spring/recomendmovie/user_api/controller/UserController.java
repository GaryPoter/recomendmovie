package com.spring.recomendmovie.user_api.controller;


import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.user_api.service.UserService;
import com.spring.recomendmovie.utils.message.Result;
import com.spring.recomendmovie.utils.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;


    /**
     *
     * @return 获得所有的用户
     */
    @RequestMapping("/getAllUser")
    public ArrayList<User> getAllUser(){
        return userService.getAll();
    }

    /**
     * 商品分页功能(集成mybatis的分页插件pageHelper实现)
     *
     * @param currentPage    :当前页数
     * @param pageSize        :每页显示的总记录数
     * @return
     */
    @RequestMapping(value = "/itemsPage/{currentPage}/{pageSize}", method = RequestMethod.GET)
    public List<User> itemsPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return itemService.findItemByPage(currentPage, pageSize);
    }

    /**
     *
     * @param users jackson 数据
     * @return
     */
    @RequestMapping("/addUser")
    public int addUser(ArrayList<User> users){
//        return new Integer(userService.addUser(new User(new Long(1), "赵正兰", "123456789")));
        return userService.addUsers(users);
    }



    @RequestMapping(value = "/getUser", method = {RequestMethod.POST, RequestMethod.GET})
    public User getUser(Long id){
        return userService.getUserById(id);
    }

    /**
     *
     * @param email 前端json中的email
     * @param password 前端json中的password
     * @return
     */
    @RequestMapping(value = "/loginAction", method = {RequestMethod.POST})
    public Result login(String email, String password, Model model, HttpSession httpSession){
        User user = userService.login(new User(new Long(-1),null, email, password));
        if(user == null){
            return new Result(Result.FAIL_CODE);
        }else {
            httpSession.setAttribute("user", user);
            return new Result(Result.SUCCESS_CODE);
        }
    }

    /**
     *
     * @param name user的昵称
     * @param email user的注册邮箱
     * @param password user的密码
     * @return
     */
    @RequestMapping(value = "/registerAction", method = RequestMethod.POST)
    public Result register(String name, String email, String password){
        return userService.register(new User(new Long(-1), name, email, password));
    }
}
