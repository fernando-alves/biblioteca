package com.twu28.biblioteca.book;


public class Book{

    private String title;
    private boolean isReserved;
    private int id;

    public Book(String bookTitle, int bookId) {
        setTitle(bookTitle);
        setId(bookId);
        this.isReserved = false;
    }

    private void setId(int bookId) {
        this.id = bookId;
    }

    private void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isReserved() {
        return this.isReserved;
    }

    public boolean reserve() {
        if (isReserved){
            return false;
        }

        isReserved = true;
        return true;
    }

    public int getId() {
        return this.id;
    }


}
