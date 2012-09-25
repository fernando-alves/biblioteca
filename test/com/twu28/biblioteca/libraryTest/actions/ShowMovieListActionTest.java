package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.actions.ShowMovieListAction;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ShowMovieListActionTest extends TestCase {

    private static final String NEW_LINE = System.getProperty("line.separator");
    private OutputStream os;
    private PrintStream ps;

    public ShowMovieListActionTest() {
        super();
    }

    public void setUp(){
        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);
    }

    public void testMovieList(){
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("The Godfather Part I", 1972, "Coppola", 9.2));
        movieList.add(new Movie("Back to the Future",1985, "Robert Zemeckis"));
        movieList.add(new Movie("The Dictator",2012, "Larry Charles", 6.5));

        Library library = new Library(new ArrayList<Book>(), movieList, new ArrayList<User>());

        ShowMovieListAction showBookListAction = new ShowMovieListAction(library);
        showBookListAction.execute(null, ps);

        String expectedMovieList = "|Movie                           |Director            |Year| Rating|"+NEW_LINE+
                "|The Dictator                    |Larry Charles       |2012|    6.5|"+NEW_LINE+
                "|Back to the Future              |Robert Zemeckis     |1985|    N/A|"+NEW_LINE+
                "|The Godfather Part I            |Coppola             |1972|    9.2|";
        System.out.println(os.toString());
        assertTrue(os.toString().trim().equals(expectedMovieList));
    }}
