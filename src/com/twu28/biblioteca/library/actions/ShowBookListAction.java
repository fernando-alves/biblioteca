package com.twu28.biblioteca.library.actions;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class ShowBookListAction implements LibraryActionInterface{

    private Library library;
    private final String NEW_LINE = System.getProperty("line.separator");

    public ShowBookListAction(Library library) {
        this.library = library;
    }

    public void execute(InputStream input, PrintStream output) {
        String bookMenu = "";
        for (Book book : library.getBooks()){
            bookMenu+=book.getId()+" - "+book.getTitle()+NEW_LINE;
        }
        output.println(bookMenu);
    }



}
