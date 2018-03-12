package com.spring.recomendmovie.movie_api.pojo;

public class Movie {

    public static final String TABLENAME = "movie";

    public static final String ID = "id";

    public static final String MOVIENAME = "movie_name";


    public static final String MOVIERESOUCEURL = "movie_resouse_url";

    public static final String IMAGEID = "image_id";

    private Long id;

    private String movie_name;

    private String movie_resouse_url;

    private String image_url;

    private String director;

    private String starring;

    private String area;

    private String duration;

    private Long typeId;

    public Movie() {
    }

    public Movie(Long id, String movie_name, String movie_resouse_url, String image_url, String director, String starring, String area, String duration, Long typeId) {
        this.id = id;
        this.movie_name = movie_name;
        this.movie_resouse_url = movie_resouse_url;
        this.image_url = image_url;
        this.director = director;
        this.starring = starring;
        this.area = area;
        this.duration = duration;
        this.typeId = typeId;
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

    public static String getTABLENAME() {
        return TABLENAME;
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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
