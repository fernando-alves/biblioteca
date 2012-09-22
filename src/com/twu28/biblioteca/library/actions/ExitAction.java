package com.twu28.biblioteca.library.actions;

import java.io.InputStream;
import java.io.PrintStream;

public class ExitAction implements LibraryActionInterface {

    public void execute(InputStream input, PrintStream output) {
        output.println("Thank You");
    }

}
