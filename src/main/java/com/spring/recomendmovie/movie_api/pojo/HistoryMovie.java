package com.spring.recomendmovie.movie_api.pojo;

public class HistoryMovie {

    private String movie_name;

    private String browsetime;

    private String image_url;

    private long movie_id;

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getBrowsetime() {
        return browsetime;
    }

    public void setBrowsetime(String browsetime) {
        this.browsetime = browsetime;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public HistoryMovie(String movie_name, String browsetime, String image_url, long movie_id) {
        this.movie_name = movie_name;
        this.browsetime = browsetime;
        this.image_url = image_url;
        this.movie_id = movie_id;
    }

    public HistoryMovie(){

    }
}
