package com.twu28.biblioteca.bookTest;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.book.BookManager;
import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookManagerTest extends TestCase {

    public BookManagerTest(){
        super();
    }


    //tests if the book list is being properly save
    public void testBookList() {
        List<Book> testBooks = new ArrayList<Book>();

        testBooks.add(new Book("Test Book A"));
        testBooks.add(new Book("Test Book B"));
        testBooks.add(new Book("Test Book C"));

        BookManager bookManager = new BookManager(testBooks);

        assertEquals(testBooks, bookManager.getBooks());

        testBooks.add(new Book("Test Book D"));

        assertNotSame(testBooks, bookManager);

    }

    //tests if a valid book index is accepted
    public void testValidBookIndex(){
        int validIndex = 0;
        List<Book> testBooks = new ArrayList<Book>();

        testBooks.add(new Book("Test Book A"));
        testBooks.add(new Book("Test Book B"));
        testBooks.add(new Book("Test Book C"));

        BookManager bookManager = new BookManager(testBooks);
//
        assertTrue(bookManager.isValidBookIndex(validIndex));

    }

    //tests if and invalid book index is rejected
    public void testInvalidBookIndex(){
        int invalidIndex = 6;
        List<Book> testBooks = new ArrayList<Book>();

        testBooks.add(new Book("Test Book A"));
        testBooks.add(new Book("Test Book B"));
        testBooks.add(new Book("Test Book C"));

        BookManager bookManager = new BookManager(testBooks);
//
        assertFalse(bookManager.isValidBookIndex(invalidIndex));
//
        int zeroIndex = 0;
        testBooks = new ArrayList<Book>();
        BookManager emptyBookManagerStub = new BookManager(testBooks);
        assertFalse(emptyBookManagerStub.isValidBookIndex(zeroIndex));
    }

    //tests if an negative book index is rejected
    public void testNegativeBookIndex(){
        int invalidIndex = -1;
        List<Book> testBooks = new ArrayList<Book>();
        testBooks.add(new Book("Test Book A"));
        testBooks.add(new Book("Test Book B"));
        testBooks.add(new Book("Test Book C"));

        BookManager bookManagerStub = new BookManager(testBooks);
//
        assertFalse(bookManagerStub.isValidBookIndex(invalidIndex));

    }

    //tests if a valid book reservation is successfully completed
    public void testReserveBookSuccess() throws FileNotFoundException {
        int bookIndex = 0;
        BookManager bookManager = new BookManager();
        boolean reservationSucceed = bookManager.reserveBook(bookIndex);
        assertTrue(reservationSucceed);

    }

    //tests if an invalid book reservation is not successfully completed
    public void testReserveBookFail() throws FileNotFoundException {
        BookManager bookManagerStub = new BookManager();
        int bookIndex = 0;
        bookManagerStub.getBooks().get(bookIndex).reserve();
        boolean reservationSucceed = bookManagerStub.reserveBook(bookIndex);
        assertFalse(reservationSucceed);
    }

    //tests if the reservation of an invalid book is not successfully completed
    public void testInvalidBookReservation(){
        List<Book> testBooks = new ArrayList<Book>();
        testBooks.add(new Book("Test Book A"));
        testBooks.add(new Book("Test Book B"));

        int invalidBookIndex = 3;
        BookManager bookManager = new BookManager(testBooks);

        boolean reservationSucceed = bookManager.reserveBook(invalidBookIndex);
        assertFalse(reservationSucceed);

        invalidBookIndex = -1;
        reservationSucceed = bookManager.reserveBook(invalidBookIndex);
        assertFalse(reservationSucceed);
    }

}
