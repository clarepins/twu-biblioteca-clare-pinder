package com.twu.biblioteca;

public class Book {
    private int ref;
    private String title;
    private String author;
    private int publicationDate;

    public Book(int refNumber, String titlePhrase, String authorName, int year) {
        ref = refNumber;
        title = titlePhrase;
        author = authorName;
        publicationDate = year;
    }

    public int getRef() {
        return ref;
    }

    public String getBookInfo() {
        return Integer.toString(ref) + ", " + title + ", " + author + ", " + Integer.toString(publicationDate);
    }

}
