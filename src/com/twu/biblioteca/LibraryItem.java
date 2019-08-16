package com.twu.biblioteca;

public class LibraryItem {
    private int ref;
    private String nameOrTitle;
    private String directorOrAuthor;
    private int year;

    public LibraryItem(int refNumber, String nameOrTitle, String directorOrAuthor, int year) {
        this.ref = refNumber;
        this.nameOrTitle = nameOrTitle;
        this.directorOrAuthor = directorOrAuthor;
        this.year = year;
    }

    public int getRef() {
        return ref;
    }

    public String getInfo() {
        return ref + ", " + nameOrTitle + ", " + directorOrAuthor + ", " + year;
    }

}
