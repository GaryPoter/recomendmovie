package com.spring.recomendmovie.movie_api.pojo;

public class ManagerInfo {

    public static final String TABLENAME="manager";

    public static final String ID="id";

    public static final String MNAME="mName";

    public static final String MPASSWORD="mPassword";

    private Long id;

    private String mName;

    private String mPassword;

    public ManagerInfo() {
    }

    public ManagerInfo(Long id, String mName, String mPassword) {
        this.id = id;
        this.mName = mName;
        this.mPassword = mPassword;
    }

    public static String getTABLENAME() {
        return TABLENAME;
    }

    public static String getID() {
        return ID;
    }

    public static String getMNAME() {
        return MNAME;
    }

    public static String getMPASSWORD() {
        return MPASSWORD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
