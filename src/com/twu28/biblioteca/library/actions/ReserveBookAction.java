package com.twu28.biblioteca.library.actions;

import com.twu28.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ReserveBookAction implements LibraryActionInterface {

    private Library library;

    public ReserveBookAction(Library library) {
        this.library = library;
    }

    public void execute(InputStream input, PrintStream output) {

        if (library.hasUserLogged()){
            output.println("Please, type the book id:");
            String scannerInput = new Scanner(input).next();
            if (library.reserveBook(scannerInput)){
                output.println("Thank You! Enjoy the book.");
            } else {
                output.println("Sorry we don't have that book yet.");
            }
        } else {
            output.println("You must be logged to do this!");
        }

    }
}