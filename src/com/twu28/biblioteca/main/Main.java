package com.twu28.biblioteca.main;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.LibraryMenu;
import com.twu28.biblioteca.library.actions.LibraryActionInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Book> builBookList(){
        Book bookA = new Book("Book A", 1);
        Book bookB = new Book("Book B", 2);
        Book bookC = new Book("Book C", 3);
        Book bookD = new Book("Book D", 4);
        Book bookE = new Book("Book E", 5);

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(bookA);
        bookList.add(bookB);
        bookList.add(bookC);
        bookList.add(bookD);
        bookList.add(bookE);

        return bookList;
    }

    public static void main(String[] args) {

        Library library = new Library(builBookList());
        LibraryMenu libraryMenu = new LibraryMenu(library);

        System.out.println(libraryMenu.welcomeMessage());

        int option;
        do {
            System.out.println(libraryMenu.mainMenu());
            option = getNextValidInput();
            LibraryActionInterface action = libraryMenu.getMenuByOption(option);
            if (action == null){
                System.out.println("Select a valid option!!");
            } else {
                action.execute(System.in, System.out);
            }
        } while (option != LibraryMenu.EXIT);
    }

    private static int getNextValidInput() {
        return new Scanner(System.in).nextInt();
    }
}
