package com.thebtnco.persistence.domain;

/**
 * Created by bobby on 10/26/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class Movie {

    private long id;
    private String name;
    private String language;
    private String requestedBy;
    private String movieState;

    public Movie(long id, String name, String language, String requestedBy, String movieState) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.requestedBy = requestedBy;
        this.movieState = movieState;
    }

    public Movie(String name, String language, String requestedBy, String movieState) {
        this.name = name;
        this.language = language;
        this.requestedBy = requestedBy;
        this.movieState = movieState;
    }

    public Movie() {
    }

    public String toString() {
        return "(ID: " + id + ", Name: " + name + ", Language: " + language + ", Requested by: " + requestedBy
                + ", Status: " + movieState + ")";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getMovieState() {
        return movieState;
    }

    public void setMovieState(String movieState) {
        this.movieState = movieState;
    }
}
