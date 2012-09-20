package com.twu28.biblioteca.book;


public class Book{

    private String title;
    private static String DEFAULT_BOOK_DETAILS = "Please talk to Librarian. Thank you.";
    private boolean isReserved;

    public Book (String title) {
        setTitle(title);
        this.isReserved = false;
    }

    public String getTitle(){
        return this.title;
    }

    private void setTitle(String title){
        this.title = title;
    }

    public String getDetails(){
        return DEFAULT_BOOK_DETAILS;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        this.isReserved = true;
    }

}
