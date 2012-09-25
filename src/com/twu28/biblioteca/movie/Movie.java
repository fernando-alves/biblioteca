package com.twu28.biblioteca.movie;

public class Movie {
    private static final String DEFAULT_GRADE = "N/A";
    private String title;
    private int year;
    private String director;
    private String rating;

    public Movie(String title, int year, String director, double rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = String.valueOf(rating);
    }

    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = DEFAULT_GRADE;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String getDirector() {
        return this.director;
    }

    public String getRating() {
        return this.rating;
    }
}
