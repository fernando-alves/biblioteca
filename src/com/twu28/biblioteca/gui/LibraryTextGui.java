package com.twu28.biblioteca.gui;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 7:58 PM
*/

/**
 * The expected services of a textual GUI.
 *
 */
public interface LibraryTextGui {

    /**
     * The welcome message.
     *
     * @return The string representation of the welcome message
     */
    public String welcomeMessage();

    /**
     * The main menu string representation.
     *
     * @return The string representation of the main menu
     */
    public String mainMenu();

    /**
     * The message to be shown when the menu option an invalid.
     *
     * @return The string representation of the message to be shown when the menu option an invalid.
     */
    public String invalidOptionMessage();

    /**
     * The message when choosing a book.
     *
     * @return The string representation of the message when choosing a book.
     */
    public String chooseBookMessage();

    /**
     * The message to be shown when a book was successfully reserved.
     *
     * @return The string representation of the message to be shown when a book was successfully reserved.
     */
    public String successBookReservationMessage();

    /**
     * The message to be shown when a book can't be reserved.
     *
     * @return The string representation of the message to be shown when a book can't be reserved.
     */
    public String notAvailableBookMessage();

    /**
     * The book menu.
     *
     * @return The string representation of the book menu
     */
    public String bookMenu(String bookTitle);

}
