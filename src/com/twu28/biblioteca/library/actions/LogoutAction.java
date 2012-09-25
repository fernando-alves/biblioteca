package com.twu28.biblioteca.library.actions;

import com.twu28.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class LogoutAction implements LibraryActionInterface{


    private Library library;
    private final String NEW_LINE = System.getProperty("line.separator");

    public LogoutAction(Library library) {
        this.library = library;
    }

    public void execute(InputStream input, PrintStream output) {
        if (!library.hasUserLogged()){
            output.println("Already logged out!");
        } else {
            String username = library.getCurrentUser().getUsername();
            library.logout();
            output.println("Logout successful! Bye, "+username);
        }

        output.println(NEW_LINE);
    }

}
