package com.twu28.biblioteca.bookTest;

import com.twu28.biblioteca.book.Book;
import junit.framework.TestCase;


public class BookTest extends TestCase{

    public BookTest() {
        super();
    }

    public void testRightBookTitle(){
        String bookTitle = "DayTripper";
        int bookId = 1;
        Book book = new Book(bookTitle, bookId);
        assertTrue(book.getTitle().compareTo(bookTitle) == 0);
    }

    public void testRightBookId(){
        String bookTitle = "DayTripper";
        int bookId = 1;
        Book book = new Book(bookTitle, bookId);

        assertTrue(book.getId() == bookId);
    }

    public void testBookReservedInitialValue(){
        String bookTitle = "Persepolis";
        int bookId = 1;
        Book book = new Book(bookTitle, bookId);

        assertFalse(book.isReserved());
    }

    public void testBookReservationSucceed(){
        String bookTitle = "Persepolis";
        int bookId = 1;
        Book book = new Book(bookTitle, bookId);

        assertTrue(book.reserve());

        assertTrue(book.isReserved());
    }

    public void testBookReservationFailed(){
        String bookTitle = "Persepolis";
        int bookId = 1;
        Book book = new Book(bookTitle, bookId);

        assertTrue(book.reserve());

        assertFalse(book.reserve());
    }

}
