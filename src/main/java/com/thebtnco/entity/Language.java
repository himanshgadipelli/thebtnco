package com.thebtnco.entity;

/**
 * Created by bobby on 10/26/2017.
 */
public enum Language {
    TELUGU("TELUGU"),
    HINDI("HINDI"),
    TAMIL("TAMIL"),
    MALAYALAM("MALAYALAM");

    private String name;

    Language(String name) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
