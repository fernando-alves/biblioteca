package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.actions.ShowDetailsAction;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ShowDetailsActionTest extends TestCase {

    private OutputStream os;
    private PrintStream ps;
    private String userFulanoPassword;
    private User userFulano;
    private Library library;
    private String NEW_LINE = System.getProperty("line.separator");

    public ShowDetailsActionTest(){
        super();
    }

    public void setUp(){
        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);

        List<User> userList = new ArrayList<User>();
        this.userFulanoPassword = "123456";
        this.userFulano = new User("111-2222", userFulanoPassword, "fulano@email.com", "+55 (34) 3342-3411", "Fulano");
        userList.add(userFulano);

        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);

        this.library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);
    }

    public void testLoggedOutDetailsMessage(){
        ShowDetailsAction showDetailsAction = new ShowDetailsAction(library);

        showDetailsAction.execute(null, ps);

        String expectedDetailsMessage = "Please talk to Librarian. Thank you.";
        assertTrue(os.toString().trim().compareTo(expectedDetailsMessage) == 0);
    }

    public void testShowUserDetails(){
        library.login(userFulano.getUsername(), userFulanoPassword);
        ShowDetailsAction showDetailsAction = new ShowDetailsAction(library);

        showDetailsAction.execute(null, ps);
        String expectedDetails = "|Name                |Email                         |Phone               |Username  |"+NEW_LINE+
                "|Fulano              |fulano@email.com              |+55 (34) 3342-3411  |111-2222  |";
        assertTrue(os.toString().trim().compareTo(expectedDetails) == 0);
    }
}
