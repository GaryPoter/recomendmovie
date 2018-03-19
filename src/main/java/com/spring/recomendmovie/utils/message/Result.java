package com.spring.recomendmovie.utils.message;

public class Result {

    private int code;
    public static final int SUCCESS_CODE = 0;

    public static final int FAIL_CODE = 1;

    public static final int NOT_LOGIN_CODE = 2;



    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Result() {
    }

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
