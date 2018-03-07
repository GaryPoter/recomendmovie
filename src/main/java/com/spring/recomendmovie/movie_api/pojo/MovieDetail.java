package com.spring.recomendmovie.movie_api.pojo;

public class MovieDetail {
    private Long id;

    private String movie_name;

    private String movie_resouse_url;

    private String image_url;

    public MovieDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_resouse_url() {
        return movie_resouse_url;
    }

    public void setMovie_resouse_url(String movie_resouse_url) {
        this.movie_resouse_url = movie_resouse_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
