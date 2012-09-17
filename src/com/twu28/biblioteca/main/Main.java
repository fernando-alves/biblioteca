package com.twu28.biblioteca.main;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.book.BookManagerFacade;
import com.twu28.biblioteca.book.stubs.BookManagerStub;
import com.twu28.biblioteca.gui.LibraryTextGui;
import com.twu28.biblioteca.gui.LibraryTextGuiImpl;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static BookManagerFacade bookManager = BookManagerStub.build();
    private static LibraryTextGui textGui = new LibraryTextGuiImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println(textGui.welcomeMessage());
        mainMenu();

    }

    //Implementation of the book list menu
    private static void bookListMenu() {

        //blank line before the book list
        System.out.println();
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

            if (option == LibraryTextGuiImpl.GO_BACK_OPTION){
                //returns to main menu
                break;

            } else {

                if (bookManager.isValidBookIndex(option-1))
                    showBookMenu(option - 1);
                else {
                    System.out.println("\n"+textGui.invalidOptionMessage());
                }

            }

        }

        //returns to main menu
        mainMenu();

    }

    //the main menu
    //it has 2 options: go to the book menu or exit the system
    private static void mainMenu(){

        System.out.println("\n"+textGui.mainMenu());

        switch (nextValidInt()){
            case LibraryTextGuiImpl.LIST_BOOKS_OPTION:
                //goes to the book list menu
                bookListMenu();
                break;
            case LibraryTextGuiImpl.EXIT_OPTION:

                System.exit(0);
                break;
            default:
                System.out.println("\n"+textGui.invalidOptionMessage());
                mainMenu();
                break;

        }

    }

    //gets the next valid integer in the system input
    private static int nextValidInt(){
        int option = -1;
        boolean validOption = false;
        do {
            String currentOption = sc.next();
            try{
                option = Integer.parseInt(currentOption);
                validOption = true;
            }catch (NumberFormatException e){
                System.out.println("\n"+textGui.invalidOptionMessage());
            }
        }while (!validOption);
        return option;
    }

    //shows the book menu
    //there are 3 options: reserve the selected book
    //                     see book details
    //                     go back
    public static void showBookMenu(int bookIndex){

        Book book = bookManager.getBooks().get(bookIndex);

        while (true) {
            System.out.println("\n"+textGui.bookMenu(book.getTitle()));

            switch (nextValidInt()){
                case LibraryTextGuiImpl.GO_BACK_OPTION:

                    //goes back to the book list menu
                    bookListMenu();
                    break;
                case LibraryTextGuiImpl.RESERVE_BOOK_OPTION:

                    //try to reserve the book
                    if (bookManager.reserveBook(bookIndex)){
                        System.out.println(textGui.successBookReservationMessage());
                    } else {
                        System.out.println(textGui.notAvailableBookMessage());
                    }

                    //goes back to book list menu
                    bookListMenu();
                    break;
                case LibraryTextGuiImpl.BOOK_DETAILS_OPTION:

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

}


