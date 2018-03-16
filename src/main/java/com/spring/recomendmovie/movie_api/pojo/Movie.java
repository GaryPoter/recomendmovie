package com.spring.recomendmovie.movie_api.pojo;

public class Movie {

    public static final String TABLENAME = "movie";

    public static final String ID = "id";

    public static final String MOVIENAME = "movie_name";


    public static final String MOVIERESOUCEURL = "movie_resouse_url";

    public static final String IMAGEID = "image_id";

    public static final String TYPEID1 = "typeId";



    private Long id;

    private String movie_name;

    private String download_url;

    private String image_url;

    private String director;

    private String star;

    private String area;

    private String duration;

    private Long type;

    private String time;

    private Double rating;

    private String mabstract;

    public Movie() {
    }

    public Movie(Long id, String movie_name, String download_url, String image_url, String director, String star, String area, String duration, Long type, String time, Double rating, String mabstract) {
        this.id = id;
        this.movie_name = movie_name;
        this.download_url = download_url;
        this.image_url = image_url;
        this.director = director;
        this.star = star;
        this.area = area;
        this.duration = duration;
        this.type = type;
        this.time = time;
        this.rating = rating;
        this.mabstract = mabstract;
    }

    public Movie(Long id, String movie_name, String download_url, String image_url, String director, String star, String area, String duration, Long type, String time, String mabstract) {
        this.id = id;
        this.movie_name = movie_name;
        this.download_url = download_url;
        this.image_url = image_url;
        this.director = director;
        this.star = star;
        this.area = area;
        this.duration = duration;
        this.type = type;
        this.time = time;
        this.mabstract = mabstract;
    }

    public static String getTABLENAME() {
        return TABLENAME;
    }

    public static String getID() {
        return ID;
    }

    public static String getMOVIENAME() {
        return MOVIENAME;
    }

    public static String getMOVIERESOUCEURL() {
        return MOVIERESOUCEURL;
    }

    public static String getIMAGEID() {
        return IMAGEID;
    }

    public static String getTYPEID1() {
        return TYPEID1;
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

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getMabstract() {
        return mabstract;
    }

    public void setMabstract(String mabstract) {
        this.mabstract = mabstract;
    }
}
