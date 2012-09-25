package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.actions.LogoutAction;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LogoutActionTest extends TestCase {

    private String userFulanoPassword;
    private User userFulano;
    private Library library;
    private ByteArrayOutputStream os;
    private PrintStream ps;

    public LogoutActionTest() {
        super();
    }

    public void setUp(){
        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);

        List<Book> bookList = new ArrayList<Book>();

        List<Movie> movieList = new ArrayList<Movie>();

        List<User> userList = new ArrayList<User>();
        this.userFulanoPassword = "123456";
        this.userFulano = new User("111-2222", userFulanoPassword, "fulano@email.com", "+55 (34) 3342-3411", "Fulano");
        userList.add(userFulano);

        this.library = new Library(bookList, movieList, userList);

    }

    public void testLoggedOut(){
        library.login(userFulano.getUsername(), userFulanoPassword);

        LogoutAction logoutAction = new LogoutAction(library);

        logoutAction.execute(null, ps);
        System.out.println(os.toString());
        assertTrue(os.toString().contains("Logout successful! Bye, "+userFulano.getUsername()));
    }

    public void testWhenAlreadyLoggedOut(){
        LogoutAction logoutAction = new LogoutAction(library);

        logoutAction.execute(null, ps);
        System.out.println(os.toString());
        assertTrue(os.toString().contains("Already logged out!"));
    }
}
