package com.giantplay.filmreview;

public class Movie {
    private final int name;
    private final int year;
    private final int imageResource;
    private boolean isFavorite = false;
    private final int desc;
    private final float rating;
    private final int reviewer;

    public Movie(int name, int year, int imageResource, int desc, float rating, int reviewer) {
        this.name = name;
        this.imageResource = imageResource;
        this.year = year;
        this.desc = desc;
        this.rating = rating;
        this.reviewer = reviewer;
    }

    public float getRating() {
        return rating;
    }

    public int getReviewer() {
        return reviewer;
    }

    public int getYear() {
        return year;
    }

    public int getDesc() {
        return desc;
    }

    public int getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void toggleFavorite() {
        isFavorite = !isFavorite;
    }
}
