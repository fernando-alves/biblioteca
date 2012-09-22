package com.twu28.biblioteca.library.actions;

import java.io.InputStream;
import java.io.PrintStream;

public class ShowDetailsAction implements LibraryActionInterface {

    public ShowDetailsAction() {
    }

    public void execute(InputStream input, PrintStream output) {
        output.println("Please talk to Librarian. Thank you.");
    }

}
