package com.twu28.biblioteca.libraryTest;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.LibraryMenu;
import com.twu28.biblioteca.library.actions.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class LibraryMenuTest extends TestCase {

    private Library library;

    private final String NEW_LINE = System.getProperty("line.separator");

    public LibraryMenuTest() {
        super();
    }

    public void setUp(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book A",1));
        bookList.add(new Book("Book B",2));
        bookList.add(new Book("Book C",3));

        this.library = new Library(bookList);
    }

    public void testGetMainMenu(){
        LibraryMenu libraryMenu = new LibraryMenu(library);

        String expectedMainMenu = "1 - Book List"+NEW_LINE+
                "2 - Reserve Book"+NEW_LINE +
                "3 - See your details"+ NEW_LINE+
                "4 - Exit";

        assertTrue(libraryMenu.mainMenu().compareTo(expectedMainMenu)==0);
    }

    public void testWelcomeMessage(){

        LibraryMenu libraryMenu = new LibraryMenu(library);

        String expectedWelcomeMessage = "Welcome to Bangalore Library!";

        assertTrue(libraryMenu.welcomeMessage().compareTo(expectedWelcomeMessage) == 0);
    }

    public void testGetBookList(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int bookListOption = 1;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(bookListOption);
        assertTrue(menuByOption instanceof ShowBookListAction);
    }

    public void testReserveBookOption(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int reserveBookOption = 2;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(reserveBookOption);
        assertTrue(menuByOption instanceof ReserveBookAction);
    }

    public void testSeeDetailsOption(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int seeDetails = 3;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(seeDetails);
        assertTrue(menuByOption instanceof ShowDetailsAction);
    }

    public void testExitOption(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int exitOption = 4;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(exitOption);
        assertTrue(menuByOption instanceof ExitAction);
    }

    public void testInvalidOption(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int invalidOption = 5;

        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(invalidOption);

        assertTrue(menuByOption == null);

        invalidOption = -1;

        menuByOption = libraryMenu.getMenuByOption(invalidOption);

        assertTrue(menuByOption == null);
    }

}