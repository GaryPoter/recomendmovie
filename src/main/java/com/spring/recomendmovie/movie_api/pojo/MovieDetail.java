package com.spring.recomendmovie.movie_api.pojo;

public class MovieDetail {
    private Long id;

    private String movie_name;

    private String movie_resouse_url;

    private String image_url;

    private String director;

    private String starring;

    private String area;

    private String duration;

    private String type_name;

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
