package com.spring.recomendmovie.user_api.pojo;

import javax.validation.constraints.NotNull;

public class User {
    public static final String TABLENAME = "user";

    public static final String ID = "id";

    public static final String NAME = "username";

    public static final String EMAIL = "email";

    public static final String PASSWORD = "password";


    @NotNull
    private Long id;

    @NotNull
//    @Size(min = 5, max = 20)
    private String username;

    @NotNull
//    @Size(min = 8, max = 20)
    private String password;

    @NotNull
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //jackson对象的转换需要默认构造函数
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
