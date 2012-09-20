package com.twu28.biblioteca.libraryTest;

import com.sun.servicetag.SystemEnvironment;
import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import junit.framework.TestCase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryTest extends TestCase {


    private OutputStream os;

    public LibraryTest(){
        super();
    }

    protected void setUp(){
        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
    }

    public void testWelcomeMenu() throws FileNotFoundException {

        String exitOption = "2";
        InputStream ip = new ByteArrayInputStream(exitOption.getBytes());
        System.setIn(ip);

        String welcomeMessage = "Welcome to Bangalore's Library";
        String menuOptions = "Please, choose an option: "+System.lineSeparator() +
                                    "1 - List books"+System.lineSeparator() +
                                    "2 - Exit";

        Library library = new Library();

        library.run();

        assertTrue(os.toString().contains(welcomeMessage));
        assertTrue(os.toString().contains(menuOptions));
    }

    public void testBookListMenu(){

        String listBooksOption = "1"+ System.lineSeparator()+"-1" +System.lineSeparator()+ "2";
        InputStream ip = new ByteArrayInputStream(listBooksOption.getBytes());
        System.setIn(ip);

        Book dayTripper = new Book("DayTripper");
        Book guinness = new Book("Guinness");

        List<Book> books = new ArrayList<Book>();
        books.add(dayTripper);
        books.add(guinness);

        Library library = new Library(books);

        library.run();

        assertTrue(os.toString().contains(dayTripper.getTitle()));
        assertTrue(os.toString().contains(guinness.getTitle()));


    }



}
