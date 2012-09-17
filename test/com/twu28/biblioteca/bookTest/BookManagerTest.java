package com.twu28.biblioteca.bookTest;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.book.stubs.BookManagerStub;
import junit.framework.TestCase;

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

        BookManagerStub bookManagerStub = BookManagerStub.build().withBooks(testBooks);

        assertEquals(testBooks, bookManagerStub.getBooks());

        testBooks.add(new Book("Test Book D"));

        assertNotSame(testBooks, bookManagerStub);

    }

    //tests if a valid book index is accepted
    public void testValidBookIndex(){
        int validIndex = 0;
        List<Book> testBooks = new ArrayList<Book>();

        testBooks.add(new Book("Test Book A"));
        testBooks.add(new Book("Test Book B"));
        testBooks.add(new Book("Test Book C"));

        BookManagerStub bookManagerStub = BookManagerStub.build().withBooks(testBooks);

        assertTrue(bookManagerStub.isValidBookIndex(validIndex));

    }

    //tests if and invalid book index is rejected
    public void testInvalidBookIndex(){
        int invalidIndex = 6;
        List<Book> testBooks = new ArrayList<Book>();

        testBooks.add(new Book("Test Book A"));
        testBooks.add(new Book("Test Book B"));
        testBooks.add(new Book("Test Book C"));

        BookManagerStub bookManagerStub = BookManagerStub.build().withBooks(testBooks);

        assertFalse(bookManagerStub.isValidBookIndex(invalidIndex));

        int zeroIndex = 0;
        testBooks = new ArrayList<Book>();
        BookManagerStub emptyBookManagerStub = BookManagerStub.build().withBooks(testBooks);
        assertFalse(emptyBookManagerStub.isValidBookIndex(zeroIndex));
    }

    //tests if an negative book index is rejected
    public void testNegativeBookIndex(){
        int invalidIndex = -1;
        List<Book> testBooks = new ArrayList<Book>();
        testBooks.add(new Book("Test Book A"));
        testBooks.add(new Book("Test Book B"));
        testBooks.add(new Book("Test Book C"));

        BookManagerStub bookManagerStub = BookManagerStub.build().withBooks(testBooks);

        assertFalse(bookManagerStub.isValidBookIndex(invalidIndex));

    }

    //tests if a valid book reservation is successfully completed
    public void testReserveBookSuccess(){
        int bookIndex = 0;
        BookManagerStub bookManagerStub = BookManagerStub.build();
        boolean reservationSucceed = bookManagerStub.reserveBook(bookIndex);
        assertTrue(reservationSucceed);

    }

    //tests if an invalid book reservation is not successfully completed
    public void testReserveBookFail(){
        BookManagerStub bookManagerStub = BookManagerStub.build();
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
        BookManagerStub bookManagerStub = BookManagerStub.build().withBooks(testBooks);

        boolean reservationSucceed = bookManagerStub.reserveBook(invalidBookIndex);
        assertFalse(reservationSucceed);

        invalidBookIndex = -1;
        reservationSucceed = bookManagerStub.reserveBook(invalidBookIndex);
        assertFalse(reservationSucceed);
    }

}
