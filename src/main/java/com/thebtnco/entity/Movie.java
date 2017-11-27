package com.thebtnco.entity;

import javax.persistence.*;

/**
 * Created by bobby on 10/26/2017.
 */
@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LANG")
    private Language language;

    @Column(name = "REQUESTED_BY")
    private String requestedBy;

    @Column(name = "MOVIE_STATE")
    private MovieState movieState;

    public Movie(String name, Language language, String requestedBy, MovieState movieState) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public MovieState getMovieState() {
        return movieState;
    }

    public void setMovieState(MovieState movieState) {
        this.movieState = movieState;
    }
}
