package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.actions.ReserveBookAction;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ReserveBookActionTest extends TestCase {


    private OutputStream os;
    private PrintStream ps;
    private Library library;

    public ReserveBookActionTest(){
        super();
    }

    protected void setUp(){
        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book A",1));
        bookList.add(new Book("Book B",2));
        bookList.add(new Book("Book C",3));

        this.library = new Library(bookList);
    }

    public void testReservationSucceed(){
        ReserveBookAction reserveBookAction = new ReserveBookAction(library);
        String validBookId = "1";
        ByteArrayInputStream input = new ByteArrayInputStream(validBookId.getBytes());
        reserveBookAction.execute(input, ps);
        String reservationSucceedMessage = "Thank You! Enjoy the book.";
        assertTrue(os.toString().contains(reservationSucceedMessage));
    }

    public void testReservationNotSucceed(){
        ReserveBookAction reserveBookAction = new ReserveBookAction(library);
        String invalidBookId = "7";
        ByteArrayInputStream input = new ByteArrayInputStream(invalidBookId.getBytes());
        reserveBookAction.execute(input, ps);
        String reservationFailedMessage = "Sorry we don't have that book yet.";
        assertTrue(os.toString().contains(reservationFailedMessage));
    }


}
