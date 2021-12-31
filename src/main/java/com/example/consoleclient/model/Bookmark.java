package com.example.consoleclient.model;

public class Bookmark {


    private int bookmarkPage;

    private Reader readerId;

    private Book bookId;

    public Bookmark(){
    }

    public int getBookmarkPage() {
        return bookmarkPage;
    }

    public void setBookmarkPage(int bookmarkPage) {
        this.bookmarkPage = bookmarkPage;
    }

    public Reader getReaderId() {
        return readerId;
    }

    public void setReaderId(Reader readerId) {
        this.readerId = readerId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
}
