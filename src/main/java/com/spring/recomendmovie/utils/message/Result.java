package com.spring.recomendmovie.utils.message;

public class Result {
    private int code;
    public static int SUCCESS_CODE = 0;

    public static int FAIL_CODE = 1;

<<<<<<< HEAD
    public static int NOT_LOGIN_CODE = 2;
=======
<<<<<<< HEAD
    public static int NOT_LOGIN = 2;
=======
    public static int NOT_LOGIN_CODE = 2;
>>>>>>> 92db22d256a3e5ba03e91f311011c5ccd1bf8266
>>>>>>> 44afb6ab8a920ace2f477b3ca87a7381fdb22208

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

    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static void setSuccessCode(int successCode) {
        SUCCESS_CODE = successCode;
    }

    public static int getFailCode() {
        return FAIL_CODE;
    }

    public static void setFailCode(int failCode) {
        FAIL_CODE = failCode;
    }
}
