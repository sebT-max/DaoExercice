package com.example.jdbci.models;

public class Livre {
    private int id;
    private String title;
    private String author;
    private double isbn;
    private boolean available;

public Livre(){
    public Livre(int id,String title,String author,String title,double isbn) {
        this.id = id;
        this.title= title;
        this.author= author;
        this.title=title;
        this.isbn=isbn;
    }
}

    public static String queryCreateTable() {
        return null;
    }

    public double getIsbn() {
        return isbn;
    }

    public void setIsbn(double isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

