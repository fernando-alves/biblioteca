package com.twu28.biblioteca.book.stubs;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.book.BookManagerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * A BookManager stub. For default, it's build with a list containing four books.
 *
 */
public class BookManagerStub extends BookManagerImpl {

    public static int DEFAULT_BOOK_QUANTITY = 4;

    /**
     * Default constructor
     *
     */
    private BookManagerStub() {
        super();
        ArrayList books = new ArrayList();
        books.add(new Book("Book A"));
        books.add(new Book("Book B"));
        books.add(new Book("Book C"));
        books.add(new Book("Book D"));
        setBookList(books);
    }

    /**
     * Builds an BookManagerStub instance
     *
     * @return BookManagerStub instance
     */
    public static BookManagerStub build(){
        return new BookManagerStub();
    }

    /**
     *
     * Sets the book list
     *
     * @param newBooks the new book list
     */
    private void setBookList(List<Book> newBooks) {
        this.books = new ArrayList<Book>();
        books.addAll(newBooks);
    }

    /**
     *
     * Builds a BookManagerStub with a copy of the given books
     *
     * @param newBooks the new BookManagerStub's books
     * @return a BookManagerStub with the given books
     */
    public BookManagerStub withBooks(List<Book> newBooks) {
        setBookList(newBooks);
        return this;
    }
}