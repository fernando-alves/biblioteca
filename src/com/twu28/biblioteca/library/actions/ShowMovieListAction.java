package com.twu28.biblioteca.library.actions;

import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.movie.Movie;

import java.io.InputStream;
import java.io.PrintStream;

public class ShowMovieListAction implements LibraryActionInterface{

    private Library library;
    private static final String NEW_LINE = System.getProperty("line.separator");

    public ShowMovieListAction(Library library) {
        this.library = library;
    }

    @Override
    public void execute(InputStream input, PrintStream output) {
        String titleColumn = "Movie";
        String yearColumn = "Year";
        String directorColumn = "Director";
        String ratingColumn = "Rating";

        output.format("|%1$-32s|%2$-20s|%3$-4s| %4$-6s|"+NEW_LINE, titleColumn, directorColumn, yearColumn, ratingColumn);
        for (Movie movie : library.getMovies()){

            output.format("|%1$-32s|%2$-20s|%3$-4d|%4$7s|"+NEW_LINE, movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating());

        }

        output.println(NEW_LINE);

    }
}
