package com.example.consoleclient.model;

import java.util.ArrayList;
import java.util.List;

public class Reader {

    private int id;

    private String readerName;

    private List<Bookmark> bookmarkReaderList = new ArrayList<>();

    public Reader(){
    }

    public Reader(String readerName){
        this.readerName = readerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public List<Bookmark> getBookmarkReaderList() {
        return bookmarkReaderList;
    }

    public void setBookmarkReaderList(List<Bookmark> bookmarkReaderList) {
        this.bookmarkReaderList = bookmarkReaderList;
    }
}
