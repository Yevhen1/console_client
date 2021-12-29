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
}
