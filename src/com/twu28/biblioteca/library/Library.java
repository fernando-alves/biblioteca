package com.twu28.biblioteca.library;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.book.BookManager;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Library {

    private BookManager bookManager;
    private LibraryTextGui textGui = new LibraryTextGui();
    private Scanner sc;

    public static Library build() throws FileNotFoundException {
        return new Library();
    }

    public static Library build(List<Book> books){

        if (books == null)
            throw new InvalidParameterException("Book list cannot be null");

        return new Library(books);
    }

    public Library () throws FileNotFoundException {
        this.sc = new Scanner(System.in);
        this.bookManager = new BookManager();
    }

    public Library (List<Book> books){
        this.sc = new Scanner(System.in);
        this.bookManager = new BookManager(books);
    }

    public void run(){

        System.out.println(textGui.welcomeMessage());
        mainMenu();

    }

    //Implementation of the book list menu
    private void bookListMenu() {

        //blank line before the book list
        System.out.println(System.lineSeparator());
        while(true) {
            Iterator it = bookManager.getBooks().iterator();
            int bookIndex = 0;

            //iterates over the book list printing the book index and its title
            while (it.hasNext()){
                Book actualBook = (Book) it.next();
                System.out.println(++bookIndex+" - "+actualBook.getTitle());
            }

            System.out.println(textGui.chooseBookMessage());
            int option = nextValidInt();

            if (option == LibraryTextGui.GO_BACK_OPTION){
                //returns to library menu
                break;

            } else {

                if (bookManager.isValidBookIndex(option-1))
                    showBookMenu(option - 1);
                else {
                    System.out.println(System.lineSeparator()+textGui.invalidOptionMessage());
                }

            }

        }

        //returns to library menu
        mainMenu();

    }

    //the library menu
    //it has 2 options: go to the book menu or exit the system
    private void mainMenu(){

        System.out.println(System.lineSeparator()+textGui.mainMenu());

        switch (nextValidInt()){
            case LibraryTextGui.LIST_BOOKS_OPTION:
                //goes to the book list menu
                bookListMenu();
                break;
            case LibraryTextGui.EXIT_OPTION:
                break;
            default:
                System.out.println(System.lineSeparator()+textGui.invalidOptionMessage());
                mainMenu();
                break;

        }

    }

    //gets the next valid integer in the system input
    private int nextValidInt(){
        int option = -1;
        boolean validOption = false;
        do {
            String currentOption = sc.next();
            try{
                option = Integer.parseInt(currentOption);
                validOption = true;
            }catch (NumberFormatException e){
                System.out.println(System.lineSeparator()+textGui.invalidOptionMessage());
            }
        }while (!validOption);
        return option;
    }

    //shows the book menu
    //there are 3 options: reserve the selected book
    //                     see book details
    //                     go back
    public void showBookMenu(int bookIndex){

        Book book = bookManager.getBooks().get(bookIndex);

        while (true) {
            System.out.println(System.lineSeparator()+textGui.bookMenu(book.getTitle()));

            switch (nextValidInt()){
                case LibraryTextGui.GO_BACK_OPTION:

                    //goes back to the book list menu
                    bookListMenu();
                    break;
                case LibraryTextGui.RESERVE_BOOK_OPTION:

                    //try to reserve the book
                    if (bookManager.reserveBook(bookIndex)){
                        System.out.println(textGui.successBookReservationMessage());
                    } else {
                        System.out.println(textGui.notAvailableBookMessage());
                    }

                    //goes back to book list menu
                    bookListMenu();
                    break;
                case LibraryTextGui.BOOK_DETAILS_OPTION:

                    //shows book details
                    System.out.println(bookManager.getBookDetails(bookIndex));
                    break;
                default:

                    //if it is an invalid option
                    System.out.println(textGui.invalidOptionMessage());
                    break;
            }
        }
    }


    private class LibraryTextGui {

        public static final int LIST_BOOKS_OPTION = 1;
        public static final int EXIT_OPTION = 2;
        public static final int GO_BACK_OPTION = -1;
        public static final int RESERVE_BOOK_OPTION = 1;
        public static final int BOOK_DETAILS_OPTION = 2;
        public String welcomeMessage() {
            return "Welcome to Bangalore's Library";
        }

        public String mainMenu() {
            return "Please, choose an option: "+System.lineSeparator() +
                    LIST_BOOKS_OPTION+ " - List books"+System.lineSeparator() +
                    EXIT_OPTION+ " - Exit";
        }

        public String invalidOptionMessage() {
            return "Select a valid option!!";
        }

        public String chooseBookMessage() {
            return "Please, choose a book (type "+ GO_BACK_OPTION + " if you want to go back):";
        }

        public String successBookReservationMessage() {
            return "Thank You! Enjoy the book.";
        }

        public String notAvailableBookMessage() {
            return "Sorry we don't have that book yet.";
        }


        public String bookMenu(String bookTitle) {
            return "You chose " + bookTitle+ System.lineSeparator()+
                    "Please, choose an option (type "+ GO_BACK_OPTION + " if you want to go back):" + System.lineSeparator()+
                    RESERVE_BOOK_OPTION + " - Reserve book "+ System.lineSeparator() +
                    BOOK_DETAILS_OPTION +" - See book details";
        }


    }

}


