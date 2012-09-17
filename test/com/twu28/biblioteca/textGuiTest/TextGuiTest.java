package com.twu28.biblioteca.textGuiTest;

import com.twu28.biblioteca.gui.LibraryTextGuiImpl;
import com.twu28.biblioteca.gui.LibraryTextGui;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextGuiTest extends TestCase {


    public TextGuiTest(){
        super();
    }

    //tests if the welcome message is build properly
    public void testWelcomeMessage(){
        LibraryTextGui textGui = new LibraryTextGuiImpl();
        assertTrue(textGui.welcomeMessage().compareToIgnoreCase("Welcome to Bangalore's Library") == 0);
    }

    //tests if the main menu is build properly
    public void testMainMenu(){
        LibraryTextGui textGui = new LibraryTextGuiImpl();
        assertTrue(textGui.mainMenu().compareToIgnoreCase("Please, choose an option: \n" +
                                                                  "1 - List books \n" +
                                                                  "2 - Exit") == 0);
    }

    //tests if the invalid option message is build properly
    public void testInvalidOptionMessage(){
        LibraryTextGui textGui = new LibraryTextGuiImpl();
        assertTrue(textGui.invalidOptionMessage().compareToIgnoreCase("Select a valid option!!") == 0);
    }

    //tests if the "choose menu" message is build properly
    public void testChooseBookMessage(){
        LibraryTextGui textGui = new LibraryTextGuiImpl();
        assertTrue(textGui.chooseBookMessage().compareToIgnoreCase("Please, choose a book (type -1 if you want to go back):") == 0);
    }

    //tests if the "successfully book reservation" message is build properly
    public void testSuccessBookReservationMessage(){
        LibraryTextGui textGui = new LibraryTextGuiImpl();
        assertTrue(textGui.successBookReservationMessage().compareToIgnoreCase("Thank You! Enjoy the book.") == 0);
    }
    //tests if the "not available book" message is build properly
    public void testNotAvailableBookMessage(){
        LibraryTextGui textGui = new LibraryTextGuiImpl();
        assertTrue(textGui.notAvailableBookMessage().compareToIgnoreCase("Sorry we don't have that book yet.") == 0);
    }


    //tests if the "successfully book reservation" message is build properly
    public void testBookMenuMessage(){
        LibraryTextGui textGui = new LibraryTextGuiImpl();
        String bookTitle = "DayTripper";
        assertTrue(textGui.bookMenu(bookTitle).compareToIgnoreCase("You chose " + bookTitle+ "\n"+
                "Please, choose an option (type -1 if you want to go back): \n"+
                "1 - Reserve book \n"+
                "2 - See book details") == 0);

    }
    //tests if the title of the book in the book menu is been properly set
    public void testWrongBookTitleMenuMessage(){
        LibraryTextGui textGui = new LibraryTextGuiImpl();
        String bookTitle = "DayTripper";
        assertFalse(textGui.bookMenu(bookTitle).compareToIgnoreCase("You chose Book A \n"+
                "Please, choose an option: \n"+
                "1 - Reserve book \n"+
                "2 - See book details \n"+
                "3 - Go back") == 0);

    }

}
