package com.spring.recomendmovie.movie_api.pojo;

public class MovieType {
    private Long type_id;

    private String type_name;

    public MovieType() {
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
