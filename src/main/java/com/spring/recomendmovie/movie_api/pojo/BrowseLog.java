package com.spring.recomendmovie.movie_api.pojo;

public class BrowseLog {
    private Long user_id;

    private Long movie_id;

    private String browsetime;

    private String image_url;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getBrowsetime() {
        return browsetime;
    }

    public void setBrowsetime(String browseTime) {
        this.browsetime = browsetime;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public BrowseLog(Long user_id, Long movie_id, String browseTime, String image_url) {

        this.user_id = user_id;
        this.movie_id = movie_id;
        this.browsetime = browseTime;
        this.image_url = image_url;
    }
}
