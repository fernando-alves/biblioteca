package com.twu28.biblioteca.library;

import com.twu28.biblioteca.library.actions.*;

public class LibraryMenu {

    public static final int SEE_DETAILS = 3;
    public static final int EXIT = 4;
    public static final int VIEW_BOOK_LIST =1;
    private static final int RESERVE_BOOK = 2;
    private static String NEW_LINE = System.getProperty("line.separator");

    private Library library;

    public LibraryMenu(Library library){
        this.library = library;
    }

    public String mainMenu(){

        return VIEW_BOOK_LIST+ " - Book List"+NEW_LINE+
                RESERVE_BOOK+ " - Reserve Book"+NEW_LINE+
                SEE_DETAILS+ " - See your details"+NEW_LINE+
                EXIT+ " - Exit";
    }

    public String welcomeMessage(){
        return "Welcome to Bangalore Library!";
    }

    public LibraryActionInterface getMenuByOption(int option){

        switch (option) {
            case VIEW_BOOK_LIST:

                return new ShowBookListAction(library);

            case RESERVE_BOOK:

                return new ReserveBookAction(library);

            case SEE_DETAILS:

                return new ShowDetailsAction();

            case EXIT:

                return new ExitAction();
            default:

                return null;
        }

    }
}
