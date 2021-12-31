package com.example.consoleclient.model;

public class Book {

    private int id;

    private String bookName;

    private int numberPages;

    private Bookmark bookmark;

    public Book(){
    }

    public Book(String bookName, int numberPages){
        this.bookName = bookName;
        this.numberPages = numberPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }
}
