package com.twu28.biblioteca.book;


import com.twu28.biblioteca.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */

/*
 * Represents a book.
 */
public class Book extends Item {

    private String title;
    private static String DEFAULT_BOOK_DETAILS = "Please talk to Librarian. Thank you.";

    /**
     * Default constructor
     *
     * @param title the book title
     */
    public Book (String title) {
        super();
        setTitle(title);

    }

    /**
    * Returns the book title
    *
    * @return the book title
    */
    public String getTitle(){
        return this.title;
    }

    /**
     * Sets the book title
     *
     * @param title the title of the book
     */
    private void setTitle(String title){
        this.title = title;
    }

    /**
     *
     * The book details
     *
     * @return The book details.
     */
    public String getDetails(){
        return DEFAULT_BOOK_DETAILS;
    }

}
