package com.spring.recomendmovie.movie_api.pojo;

public class MovieType {

    public static final String TABLENAME = "type";
    public static final String TYPEID = "id";


    private Long id;

    private String type;

    public MovieType() {
    }

    public MovieType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public static String getTABLENAME() {
        return TABLENAME;
    }

    public static String getTYPEID() {
        return TYPEID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
