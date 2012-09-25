package com.twu28.biblioteca.library;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;

import java.util.*;


public class Library {

    private HashMap<Integer, Book> bookMap;
    private HashMap<String, Movie> movieMap;
    private HashMap<String, User> userMap;
    private User currentUser;


    public Library(List<Book> books, List<Movie> movies, List<User> users) {
        setBookList(books);
        setMovieList(movies);
        setUserList(users);
    }

    private void setUserList(List<User> users) {
        this.userMap = new HashMap<String, User>();
        for (User user : users){
            userMap.put(user.getUsername(), user);
        }
    }

    private void setMovieList(List<Movie> movieList) {
        this.movieMap = new HashMap<String, Movie>();
        for (Movie movie : movieList){
            movieMap.put(movie.getTitle(), movie);
        }
    }

    private void setBookList(List<Book> books) {
        this.bookMap = new HashMap<Integer, Book>();
        for (Book book : books){
            bookMap.put(book.getId(), book);
        }
    }

    public boolean reserveBook(String bookId) {

        try {
            int id = Integer.parseInt(bookId);
            if (bookMap.containsKey(id)){
                return bookMap.get(id).reserve();
            }
        } catch (NumberFormatException e) {
            return false;
        }


        return false;
    }

    public Collection<Book> getBooks() {
        return bookMap.values();
    }

    public Collection<Movie> getMovies() {
        return movieMap.values();
    }

    public boolean login(String username, String password) {
        if (userMap.containsKey(username)){
            User user = userMap.get(username);
            if (user.isCorrectPassword(password)){
                this.currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void logout(){
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public boolean hasUserLogged() {
        return this.currentUser != null;
    }

}


