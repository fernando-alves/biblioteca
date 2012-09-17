package com.twu28.biblioteca.bookTest;

import com.twu28.biblioteca.book.Book;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookTest extends TestCase{

    public BookTest(){
        super();
    }

    //tests the title of the book
    //it should be equals to the used in the book's constructor
    public void testValidBookTitle(){
        String bookName = "DayTripper";
        Book book = new Book(bookName);
        assertTrue(bookName.compareTo(book.getTitle()) == 0);
    }

    //tests if the book is created with the default details
    public void testBookDetails() {
        String defaultBookDetails = "Please talk to Librarian. Thank you.";
        String bookName = "Mapas do Acaso";
        Book book = new Book(bookName);

        assertTrue(book.getDetails().compareTo(defaultBookDetails) == 0);
    }

}
