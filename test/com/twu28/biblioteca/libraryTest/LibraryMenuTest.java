package com.twu28.biblioteca.libraryTest;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.LibraryMenu;
import com.twu28.biblioteca.library.actions.*;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class LibraryMenuTest extends TestCase {

    private Library library;

    private final String NEW_LINE = System.getProperty("line.separator");

    private User user;

    private String userPassword;

    public LibraryMenuTest() {
        super();
    }

    public void setUp(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book A",1));
        bookList.add(new Book("Book B",2));
        bookList.add(new Book("Book C",3));

        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("The Godfather Part I", 1972, "Coppola", 9.2));
        movieList.add(new Movie("Back to the Future",1985, "Robert Zemeckis"));
        movieList.add(new Movie("The Dictator",2012, "Larry Charles", 6.5));

        List<User> userList = new ArrayList<User>();
        this.userPassword = "123456";
        this.user = new User("111-2222", userPassword, "first@email.com", "+55 (34) 3342-3411", "First");

        userList.add(user);


        this.library = new Library(bookList, movieList, userList);

    }

    public void testNotLoggedMainMenu(){
        LibraryMenu libraryMenu = new LibraryMenu(library);

        String expectedMainMenu = "1 - Book List"+NEW_LINE+
                "2 - Movie List"+NEW_LINE +
                "3 - See your details"+ NEW_LINE+
                "4 - Login/Logout"+NEW_LINE+
                "6 - Exit";

        assertTrue(libraryMenu.mainMenu().compareTo(expectedMainMenu)==0);
    }

    public void testLoggedMainMenu(){
        LibraryMenu libraryMenu = new LibraryMenu(library);

        assertTrue(library.login(user.getUsername(), userPassword));


        String expectedMainMenu = "1 - Book List"+NEW_LINE+
                "2 - Movie List"+NEW_LINE +
                "3 - See your details"+ NEW_LINE+
                "4 - Login/Logout"+NEW_LINE+
                "5 - Reserve Book"+NEW_LINE+
                "6 - Exit";

        assertTrue(libraryMenu.mainMenu().compareTo(expectedMainMenu)==0);
    }

    public void testWelcomeMessage(){

        LibraryMenu libraryMenu = new LibraryMenu(library);

        String expectedWelcomeMessage = "Welcome to Bangalore Library!";

        assertTrue(libraryMenu.welcomeMessage().compareTo(expectedWelcomeMessage) == 0);
    }

    public void testGetLoginOption(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int loginOption = 4;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(loginOption);
        assertTrue(menuByOption instanceof LoginAction);
    }

    public void testGetLogoutOption(){

        library.login(user.getUsername(), userPassword);
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int loginOption = 4;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(loginOption);
        assertTrue(menuByOption instanceof LogoutAction);
    }

    public void testGetBookList(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int bookListOption = 1;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(bookListOption);
        assertTrue(menuByOption instanceof ShowBookListAction);
    }

    public void testReserveBookOptionWhenLogged(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        library.login(user.getUsername(), userPassword);
        int reserveBookOption = 5;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(reserveBookOption);
        assertTrue(menuByOption instanceof ReserveBookAction);
    }

    public void testReserveBookOptionWhenNotLogged(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int reserveBookOption = 5;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(reserveBookOption);
        assertTrue(menuByOption == null);
    }

    public void testSeeDetailsOption(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int seeDetails = 3;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(seeDetails);
        assertTrue(menuByOption instanceof ShowDetailsAction);
    }

    public void testMovieList(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int movieListOption = 2;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(movieListOption);
        assertTrue(menuByOption instanceof ShowMovieListAction);
    }

    public void testExitOption(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int exitOption = 6;
        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(exitOption);
        assertTrue(menuByOption instanceof ExitAction);
    }



    public void testInvalidOption(){
        LibraryMenu libraryMenu = new LibraryMenu(library);
        int invalidOption = 7;

        LibraryActionInterface menuByOption = libraryMenu.getMenuByOption(invalidOption);

        assertTrue(menuByOption == null);

        invalidOption = -1;

        menuByOption = libraryMenu.getMenuByOption(invalidOption);

        assertTrue(menuByOption == null);
    }
}