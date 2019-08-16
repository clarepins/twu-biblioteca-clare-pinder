package com.twu.biblioteca;

public class Movie extends LibraryItem {
    private int rating;

    public Movie(int refNumber, String nameOrTitle, String directorOrAuthor, int year, int rating) {
        super(refNumber, nameOrTitle, directorOrAuthor, year);
        this.rating = rating;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Rating: " + rating;
    }
}
