package com.twu28.biblioteca.gui;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * An implementation of the LibraryTextGui
 *
 */
public class LibraryTextGuiImpl implements LibraryTextGui {

    public static final int LIST_BOOKS_OPTION = 1;
    public static final int EXIT_OPTION = 2;
    public static final int GO_BACK_OPTION = -1;
    public static final int RESERVE_BOOK_OPTION = 1;
    public static final int BOOK_DETAILS_OPTION = 2;

    /**
     * {@inheritDoc}
     */
    public String welcomeMessage() {
        return "Welcome to Bangalore's Library";
    }

    /**
     * {@inheritDoc}
     */
    public String mainMenu() {
        return "Please, choose an option: \n" +
                LIST_BOOKS_OPTION+ " - List books \n" +
                EXIT_OPTION+ " - Exit";
    }

    /**
     * {@inheritDoc}
     */
    public String invalidOptionMessage() {
        return "Select a valid option!!";
    }

    /**
     * {@inheritDoc}
     */
    public String chooseBookMessage() {
        return "Please, choose a book (type "+ GO_BACK_OPTION + " if you want to go back):";
    }

    /**
     * {@inheritDoc}
     */
    public String successBookReservationMessage() {
        return "Thank You! Enjoy the book.";
    }

    /**
     * {@inheritDoc}
     */
    public String notAvailableBookMessage() {
        return "Sorry we don't have that book yet.";
    }

    /**
     * {@inheritDoc}
     */
    public String bookMenu(String bookTitle) {
        return "You chose " + bookTitle+ "\n"+
                "Please, choose an option (type "+ GO_BACK_OPTION + " if you want to go back): \n"+
                RESERVE_BOOK_OPTION + " - Reserve book \n"+
                BOOK_DETAILS_OPTION +" - See book details";
    }


}
