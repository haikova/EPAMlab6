package com.example.olya.myapplication;


public class Cartoon {
    private String name;
    private int imageId;

    Cartoon(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;

    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
