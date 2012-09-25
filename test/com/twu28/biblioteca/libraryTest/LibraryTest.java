package com.twu28.biblioteca.libraryTest;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest extends TestCase{

    public LibraryTest(){
        super();
    }

    public void testLibraryBookList(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book A",1));
        bookList.add(new Book("Book B",2));
        bookList.add(new Book("Book C",3));

        Library library = new Library(bookList, new ArrayList<Movie>(), new ArrayList<User>());

        assertTrue(library.getBooks().size() == bookList.size());

        for (Book book : bookList){
            assertTrue(library.getBooks().contains(book));
        }


    }

    public void testDiferentBookList(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book A",1));
        bookList.add(new Book("Book B",2));
        bookList.add(new Book("Book C",3));

        Library library = new Library(bookList, new ArrayList<Movie>(), new ArrayList<User>());

        assertTrue(library.getBooks().size() == bookList.size());

        for (Book book : bookList){
            assertTrue(library.getBooks().contains(book));
        }

        Book newBook = new Book("Book D", 4);
        bookList.add(newBook);

        assertFalse(library.getBooks().contains(newBook));

    }

    public void testSucessfullReservation(){
        List<Book> bookList = new ArrayList<Book>();
        Book bookA = new Book("Book A",1);
        Book bookB = new Book("Book B",2);

        bookList.add(bookA);
        bookList.add(bookB);

        Library library = new Library(bookList,new ArrayList<Movie>(), new ArrayList<User>());

        assertTrue(library.reserveBook(String.valueOf(bookA.getId())));
        assertTrue(library.reserveBook(String.valueOf(bookB.getId())));
    }

    public void testUnsuccessfullyReservation(){
        List<Book> bookList = new ArrayList<Book>();
        Book bookA = new Book("Book A",1);
        Book bookB = new Book("Book B",2);

        assertTrue(bookA.reserve());
        assertTrue(bookB.reserve());

        bookList.add(bookA);
        bookList.add(bookB);

        Library library = new Library(bookList,new ArrayList<Movie>(), new ArrayList<User>());

        assertFalse(library.reserveBook(String.valueOf(bookA.getId())));
        assertFalse(library.reserveBook(String.valueOf(bookB.getId())));

    }

    public void testReserveInvalidBook(){
        List<Book> bookList = new ArrayList<Book>();
        Book bookA = new Book("Book A",1);
        Book bookB = new Book("Book B",2);

        bookList.add(bookA);
        bookList.add(bookB);

        Library library = new Library(bookList,new ArrayList<Movie>(), new ArrayList<User>());

        Book invalidBook = new Book("Book C", 3);

        assertFalse(library.reserveBook(String.valueOf(invalidBook.getId())));
    }

    public void testLibraryMovieList(){

        List<Book> bookList = new ArrayList<Book>();
        Book bookA = new Book("Book A",1);
        Book bookB = new Book("Book B",2);

        bookList.add(bookA);
        bookList.add(bookB);

        List<Movie> movieList = new ArrayList<Movie>();

        movieList.add(new Movie("Puppetmaster", 1989, "David Schmoeller", 5.7));
        movieList.add(new Movie("Super", 2010, "James Gunn", 6.8));
        movieList.add(new Movie("Full Metal Jacket",  1987, "Stanley Kubrick", 8.4));

        Library library = new Library(bookList, movieList, new ArrayList<User>());

        for (Movie movie : movieList){
            library.getMovies().contains(movie);
        }

    }

    public void testUserLoginSucceed() {
        String password = "123487765";

        User user = new User("111-2222", password, "email@email.com", "+55 (34) 3342-3411", "Fulano");

        List<User> userList = new ArrayList<User>();
        userList.add(user);

        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);

        assertTrue(library.login(user.getUsername(), password));

    }

    public void testUserLoginFail() {
        String password = "123487765";

        User user = new User("111-2222", password, "email@email.com", "+55 (34) 3342-3411", "Fulano");

        List<User> userList = new ArrayList<User>();

        userList.add(user);

        String typedPassword = "123456";

        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);

        assertFalse(library.login(user.getUsername(), typedPassword));

    }

    public void testCurrentUserAfterLogin() {
        String password = "123487765";

        User user = new User("111-2222", password, "email@email.com", "+55 (34) 3342-3411", "Fulano");

        List<User> userList = new ArrayList<User>();
        userList.add(user);

        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);

        assertTrue(library.login(user.getUsername(), password));

        assertTrue(library.getCurrentUser().equals(user) );
    }

    public void testCurrentUserBeforeAnyLogin(){

        User user = new User( "111-2222", "123487765", "email@email.com", "+55 (34) 3342-3411", "Fulano");

        List<User> userList = new ArrayList<User>();
        userList.add(user);

        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);

        assertTrue(library.getCurrentUser() == null);
    }

    public void testUserChangedAfterLogin(){

        String firstUserPassword = "123487765";

        String secondUserPassword = "123456";

        User firstUser = new User("111-2222", firstUserPassword, "first@email.com", "+55 (34) 3342-3411", "First");
        User secondUser = new User("111-2223", secondUserPassword, "second@email.com" , "+55 (42) 3314-1553", "Second");

        List<User> userList = new ArrayList<User>();

        userList.add(firstUser);
        userList.add(secondUser);

        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);

        assertTrue(library.login(firstUser.getUsername(), firstUserPassword));

        assertTrue(library.getCurrentUser().equals(firstUser));

        assertTrue(library.login(secondUser.getUsername(), secondUserPassword));

        assertTrue(library.getCurrentUser().equals(secondUser));
    }

    public void testUserLogged(){
        String userPassword = "123487765";
        User user = new User( "111-2222", userPassword, "email@email.com", "+55 (34) 3342-3411", "Fulano");

        List<User> userList = new ArrayList<User>();
        userList.add(user);

        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);

        assertTrue(library.login(user.getUsername(), userPassword));

        assertTrue(library.hasUserLogged());
    }

    public void testNoUserLogged(){
        String userPassword = "123487765";
        User user = new User( "111-2222", userPassword, "email@email.com", "+55 (34) 3342-3411", "Fulano");

        List<User> userList = new ArrayList<User>();
        userList.add(user);

        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);

        assertFalse(library.hasUserLogged());
    }

    public void testNoUserLoggedAfterLogout(){
        String userPassword = "123487765";
        User user = new User( "111-2222", userPassword, "email@email.com", "+55 (34) 3342-3411", "Fulano");

        List<User> userList = new ArrayList<User>();
        userList.add(user);

        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>(), userList);

        assertTrue(library.login(user.getUsername(), userPassword));

        assertTrue(library.hasUserLogged());

        library.logout();

        assertFalse(library.hasUserLogged());
    }

}
