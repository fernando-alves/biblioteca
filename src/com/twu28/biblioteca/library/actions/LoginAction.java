package com.twu28.biblioteca.library.actions;

import com.twu28.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;



public class LoginAction implements LibraryActionInterface{

    private final String NEW_LINE = System.getProperty("line.separator");
    private Library library;

    public LoginAction(Library library) {
        this.library = library;
    }

    public void execute(InputStream input, PrintStream output) {
        Scanner  sc = new Scanner(input);

        output.println("Please, type your username:");
        String username = sc.next();

        output.println("Please, type your password:");
        String password = sc.next();

        if (library.login(username, password)){
            output.println("Login successful! Welcome "+username);
        } else {
            output.println("Sorry, wrong username/password combination.");
        }

        output.println(NEW_LINE);
    }

}
