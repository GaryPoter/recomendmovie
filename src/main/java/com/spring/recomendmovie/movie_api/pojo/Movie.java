package com.spring.recomendmovie.movie_api.pojo;

public class Movie {

    public static final String TABLENAME = "movie";

    public static final String ID = "id";

    public static final String MOVIENAME = "movie_name";

    public static final String MOVIERESOUCEURL = "movie_resouse_url";

    public static final String IMAGEID = "image_id";

    public static final String CATEGORYID = "category_id";

    private Long id;

    private String movie_name;

    private String movie_resouse_url;

    private Long image_id;

    private Long category_id;

    public Movie() {
    }

    public Movie(Long id, String movie_name, String movie_resouse_url, Long image_id, Long category_id) {
        this.id = id;
        this.movie_name = movie_name;
        this.movie_resouse_url = movie_resouse_url;
        this.image_id = image_id;
        this.category_id = category_id;
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

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
