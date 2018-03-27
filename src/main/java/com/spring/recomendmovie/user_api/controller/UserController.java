package com.spring.recomendmovie.user_api.controller;



import com.spring.recomendmovie.comment_api.pojo.CommentDetail;
import com.spring.recomendmovie.comment_api.service.CommentService;
import com.spring.recomendmovie.movie_api.pojo.Movie;
import com.spring.recomendmovie.movie_api.service.MovieService;
import com.spring.recomendmovie.user_api.pojo.User;
import com.spring.recomendmovie.user_api.service.UserService;
import com.spring.recomendmovie.utils.PageBean;
import com.spring.recomendmovie.utils.message.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.rmi.server.UID;
import java.util.ArrayList;

@RestController
@RequestMapping("/movie/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private CommentService commentService;

//    @Autowired
//    private ItemService itemService;

    private HttpServletRequest request;

    private HttpSession session=null;

    private static Result SUCCESS = new Result(Result.SUCCESS_CODE);

    private static Result FAIL = new Result(Result.FAIL_CODE);
    /**
     *
     * @return 获得所有的用户
     */
    @RequestMapping("/getAllUser")
    public ArrayList<User> getAllUser(){
        return userService.getAll();
    }

     /**
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

    @RequestMapping(value = "/loginAction", method = {RequestMethod.POST})
    public Result login(String email, String password, Model model, HttpSession httpSession) {
        User user = userService.login(new User(new Long(-1), null, email, password));
        if (user == null) {
            return new Result(Result.FAIL_CODE);
        } else {
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
    public Result register(String name, String email, String password,
                           HttpSession httpSession){
        User user = new User(new Long(-1), name, email, password);
        Result result = userService.register(user);
        if (result.getCode() == Result.SUCCESS_CODE){
            httpSession.setAttribute("user", userService.login(user));
        }
        return result;
    }

    @PostMapping(value = "/delete")
    public Result deleteUser(Long id){
        User user = new User();
        user.setId(id);
        return userService.deleteUser(user);
    }

    @PostMapping(value = "/update")
    public Result updateUser(User user){
        return userService.updateUser(user);
    }

    @PostMapping(value="/batchDelete")
    public Result batchDelete(String chestr){
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        String[] strArr = null;
        strArr=chestr.split(",");
        for(int i=0;i<strArr.length;i++){
            Long uId= Long.valueOf(strArr[i]);
            boolean ifDelete=userService.deleteUserById(uId);
            if(ifDelete==false){
                result.setCode(Result.FAIL_CODE);
                break;
            }
        }
        return result;

    }
    @RequestMapping(value = "/userHome/{id}/{currentPage}",method=RequestMethod.GET)
    public ModelAndView userHome(@PathVariable("id") Long id,@PathVariable("currentPage") Integer currentPage, Model model,HttpSession httpSession){
        if(httpSession.getAttribute("user")!=null) {
            int pageSize = 7;
            ModelAndView modelAndView = new ModelAndView("user/userHome");
            User user = userService.getUserById(id);
            modelAndView.addObject("user", user);
            ArrayList<Movie> movies = movieService.getAllLookingMoviesByUId(id);
            modelAndView.addObject("lookingMovies", movies);
            ArrayList<Movie> movies1 = movieService.getTopTenMovies4(user.getId());
            modelAndView.addObject("movies1", movies1);
            ArrayList<CommentDetail> commentDetails = commentService.getAllCommentsByUserId(id);
            modelAndView.addObject("commentDetails", commentDetails);
            ArrayList<CommentDetail> commentDetails1 = commentService.getAllCommentsByUserIdP(id, currentPage, pageSize);
            PageBean pageBean = new PageBean(currentPage, pageSize, commentDetails1, commentDetails.size());
            int lenth = commentDetails.size();
            modelAndView.addObject("count", lenth);
            modelAndView.addObject("pageBean", pageBean);
            modelAndView.addObject("commentDetails1", commentDetails1);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/login");
            return modelAndView;
        }
    }
}
