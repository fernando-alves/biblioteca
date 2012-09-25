package com.twu28.biblioteca.library;

import com.twu28.biblioteca.library.actions.*;

public class LibraryMenu {
    private static final int SEE_DETAILS = 3;
    public static final int EXIT = 6;
    private static final int VIEW_BOOK_LIST =1;
    private static final int RESERVE_BOOK = 5;
    private static final int VIEW_MOVIE_LIST = 2;
    private static final int LOGIN = 4;
    private static String NEW_LINE = System.getProperty("line.separator");

    private Library library;

    public LibraryMenu(Library library){
        this.library = library;
    }

    public String mainMenu(){

        String mainMenu = VIEW_BOOK_LIST+ " - Book List"+NEW_LINE+
                VIEW_MOVIE_LIST+" - Movie List"+NEW_LINE+
                SEE_DETAILS+ " - See your details"+NEW_LINE+
                LOGIN+ " - Login/Logout"+NEW_LINE;


        if (library.hasUserLogged()){
            mainMenu+=RESERVE_BOOK+ " - Reserve Book"+NEW_LINE;
        }

        mainMenu+=EXIT+ " - Exit";

        return mainMenu;
    }

    public String welcomeMessage(){
        return "Welcome to Bangalore Library!";
    }

    public LibraryActionInterface getMenuByOption(int option){

        switch (option) {
            case VIEW_BOOK_LIST:

                return new ShowBookListAction(library);

            case RESERVE_BOOK:

                return library.hasUserLogged() ? new ReserveBookAction(library) : null;

            case SEE_DETAILS:

                return new ShowDetailsAction(library);

            case VIEW_MOVIE_LIST:

                return new ShowMovieListAction(library);

            case EXIT:

                return new ExitAction();

            case LOGIN:

                return library.hasUserLogged()? new LogoutAction(library) : new LoginAction(library);
            default:

                return null;
        }

    }


}
