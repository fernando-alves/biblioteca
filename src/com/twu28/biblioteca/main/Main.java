package com.twu28.biblioteca.main;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.LibraryMenu;
import com.twu28.biblioteca.library.actions.LibraryActionInterface;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;

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

    public static List<Movie> builMovieList(){
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("The Godfather Part I", 1972, "Coppola", 9.2));
        movieList.add(new Movie("The Godfather Part II", 1974, "Coppola", 9.1));
        movieList.add(new Movie("The Godfather Part III", 1990, "Coppola", 7.6));
        movieList.add(new Movie("Back to the Future",1985, "Robert Zemeckis", 8.5));
        movieList.add(new Movie("Back to the Future Part II",1990, "Robert Zemeckis", 7.7));
        movieList.add(new Movie("Back to the Future Part III",1990, "Robert Zemeckis", 7.3));
        movieList.add(new Movie("Borat",2006, "Larry Charles", 7.4));
        movieList.add(new Movie("Bruno",2009, "Larry Charles", 6));
        movieList.add(new Movie("The Dictator",2012, "Larry Charles"));
        movieList.add(new Movie("Ted",2012, "Seth MacFarlane"));
        movieList.add(new Movie("Elite Squad",2007, "Jose Padilha", 8.0));
        movieList.add(new Movie("Elite Squad 2",2010, "Seth MacFarlane", 8.2));
        movieList.add(new Movie("Toy Story",1995, "John Lasseter", 8.3));
        movieList.add(new Movie("Toy Story 2",1999, "John Lasseter", 8.0));
        movieList.add(new Movie("Toy Story 3",2012, "Lee Unkrich", 8.5));



        return movieList;
    }

    public static List<User> buildUserList(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("111-1111", "1234", "fulano@email.com", "+55 (42) 4424-4422", "Fulano"));
        userList.add(new User("111-1112", "5678", "cicrano@email.com", "+55 (42) 4424-4422", "Cicrano"));
        userList.add(new User("111-1113", "9012", "korra@email.com", "+55 (42) 4424-4422", "Korra"));
        userList.add(new User("111-1114", "3456", "leno@email.com", "+55 (42) 4424-4422", "Leno"));
        userList.add(new User("111-1115", "7890", "himura@email.com", "+55 (42) 4424-4422", "Himura"));
        userList.add(new User("111-1116", "4321", "norris@email.com", "+55 (42) 4424-4422", "Norris"));
        userList.add(new User("111-1117", "8765", "sly@email.com", "+55 (42) 4424-4422", "Sly"));
        userList.add(new User("111-1118", "0987", "gessinger@email.com", "+55 (42) 4424-4422", "Gessinger"));
        userList.add(new User("111-1119", "0000", "droid@email.com", "+55 (42) 4424-4422", "Droid"));
        userList.add(new User("111-1120", "a314", "azaghal@email.com", "+55 (42) 4424-4422", "Azaghal"));

        return userList;
    }

    public static void main(String[] args) {

        Library library = new Library(builBookList(), builMovieList(), buildUserList());
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
