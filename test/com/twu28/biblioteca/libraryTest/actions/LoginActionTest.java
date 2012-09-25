package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.actions.LoginAction;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginActionTest extends TestCase {

    private String userFulanoPassword;
    private User userFulano;
    private Library library;
    private ByteArrayOutputStream os;
    private PrintStream ps;
    private String NEW_LINE = System.getProperty("line.separator");
    private String userCicranoPassword;
    private User userCicrano;

    public LoginActionTest() {
        super();
    }

    public void setUp(){
        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);

        List<Book> bookList = new ArrayList<Book>();

        List<Movie> movieList = new ArrayList<Movie>();

        List<User> userList = new ArrayList<User>();
        this.userFulanoPassword = "123456";
        this.userCicranoPassword = "654321";
        this.userFulano = new User("111-2222", userFulanoPassword, "fulano@email.com", "+55 (34) 3342-3411", "Fulano");
        this.userCicrano = new User("111-2223", userCicranoPassword, "cicrano@email.com", "+55 (65) 7352-4422", "Cicrano");
        userList.add(userFulano);
        userList.add(userCicrano);


        this.library = new Library(bookList, movieList, userList);

    }

    public void testSuccessfulLogin(){

        ByteArrayInputStream userInput = new ByteArrayInputStream(getInputForLogin(userFulano.getUsername(), userFulanoPassword));

        LoginAction loginAction = new LoginAction(library);
        loginAction.execute(userInput,ps);

        assertTrue(os.toString().contains("Login Succefull! Welcome 111-2222"));
        assertTrue(library.hasUserLogged());
        assertTrue(library.getCurrentUser().equals(userFulano));
    }

    public void testUnsuccessfulLogin(){

        String wrongPassword = "wrongPassword";

        ByteArrayInputStream userInput = new ByteArrayInputStream(getInputForLogin(userFulano.getUsername(), wrongPassword));

        LoginAction loginAction = new LoginAction(library);
        loginAction.execute(userInput,ps);

        assertTrue(os.toString().contains("Sorry, wrong username/password combination."));
    }

    public void testUserChangedAfterLogin(){


        ByteArrayInputStream userInput = new ByteArrayInputStream(getInputForLogin(userFulano.getUsername(), userFulanoPassword));

        LoginAction loginAction = new LoginAction(library);
        loginAction.execute(userInput,ps);

        assertTrue(os.toString().contains("Login Succefull! Welcome 111-2222"));
        assertTrue(library.hasUserLogged());
        assertTrue(library.getCurrentUser().equals(userFulano));

        userInput = new ByteArrayInputStream(getInputForLogin(userCicrano.getUsername(), userCicranoPassword));

        loginAction.execute(userInput, ps);
        System.out.println(os.toString());
        assertTrue(os.toString().contains("Login Succefull! Welcome 111-2223"));
        assertTrue(library.hasUserLogged());
        assertTrue(library.getCurrentUser().equals(userCicrano));

    }


    public byte[] getInputForLogin(String username, String password){

        byte[] usernameByteArray = Arrays.copyOf(username.getBytes(), username.getBytes().length + NEW_LINE.getBytes().length);
        System.arraycopy(NEW_LINE.getBytes(), 0, usernameByteArray, username.getBytes().length, NEW_LINE.getBytes().length);

        byte[] userInputByteArray = Arrays.copyOf(usernameByteArray, usernameByteArray.length+password.length());
        System.arraycopy(password.getBytes(),0 , userInputByteArray, usernameByteArray.length, password.getBytes().length);

        return userInputByteArray;
    }
}
