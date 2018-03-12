package com.spring.recomendmovie.user_api.controller;


import com.spring.recomendmovie.user_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD


@Controller //用于标记一个类，表明这个类是一个SpringMVC Controller对象，即一个控制器类
            //这个类中，只有使用@RequestMapping注解的方法才是真正处理请求的处理器
@RequestMapping("/movie/user") //该注解用于类上时，表示类中的所有响应请求的方法都是以该地址作为父路径（提供初步的请求映射信息。相对于 WEB 应用的根目录）
=======
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;


@Controller
@RequestMapping("/movie/user")
>>>>>>> origin/my
public class UserPageController {
    @Autowired
    private UserService userService;

<<<<<<< HEAD
    @RequestMapping("/userManage")//@RequestMapping注解用来处理请求地址映射，value="/userManage"表示请求由userManage方法进行处理（提供进一步的细分映射信息。 相对于类定义处的 URL）
    public String userManage(Model model){
        model.addAttribute("users", userService.getAll());  //model中添加了一个名为"users"的字符串对象，该对象可以在返回的视图中通过
                                                               //request对象获取
        return "user/user_manage";//返回字符串"user/user_manage"作为视图名称
=======
    @RequestMapping("/userManage")
    public String userManage(Model model){
        model.addAttribute("users", userService.getAll());
        return "user/user_manage";
>>>>>>> origin/my
    }

    @RequestMapping("/home")
    public String user(Model model){
        model.addAttribute("user",userService.getUserById(new Long(1)));
        return "user/user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String registerPage(){
        return "register";
    }
<<<<<<< HEAD
=======

    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession httpSession){
        httpSession.setAttribute("user", null);
        return "index";
    }
>>>>>>> origin/my
}
