package com.twu28.biblioteca.library.actions;

import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.user.User;

import java.io.InputStream;
import java.io.PrintStream;

public class ShowDetailsAction implements LibraryActionInterface {


    private final String DETAILS_MESSAGE = "Please talk to Librarian. Thank you.";
    private Library library;
    private final String NEW_LINE = System.getProperty("line.separator");

    public ShowDetailsAction(Library library) {
        this.library = library;
    }

    public void execute(InputStream input, PrintStream output) {
        if (library.hasUserLogged()){
            String nameColumn = "Name";
            String emailColumn = "Email";
            String phoneColumn = "Phone";
            String usernameColumn = "Username";

            User currentUser = library.getCurrentUser();

            output.format("|%1$-20s|%2$-30s|%3$-20s|%4$-10s|"+NEW_LINE, nameColumn, emailColumn, phoneColumn, usernameColumn);
            output.format("|%1$-20s|%2$-30s|%3$-20s|%4$-10s|"+NEW_LINE, currentUser.getName(), currentUser.getEmail(), currentUser.getPhone(), currentUser.getUsername());

        }else {
            output.println(DETAILS_MESSAGE);
        }

        output.println(NEW_LINE);
    }


}
