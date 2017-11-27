package com.thebtnco.entity;

/**
 * Created by bobby on 10/26/2017.
 */
public enum MovieState {
    NOT_UPLOADED("REQUESTED"),
    UPLOADED("UPLOADED"),
    IN_PROGRESS("IN_PROGRESS"),
    NOT_FOUND("NOT_FOUND");

    private String name;

    MovieState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
