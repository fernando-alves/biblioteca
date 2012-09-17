package com.twu28.biblioteca.book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * An implementation of BookManagerFacade
 *
 */
public class BookManagerImpl implements BookManagerFacade{

    private static BookManagerImpl instance = new BookManagerImpl();

    protected List<Book> books;


    /**
     * Gets a BookManagerImpl object
     * @return a BookManagerImpl object
     */
    public static BookManagerImpl getInstance() {
        return instance;
    }

    /**
     * Default constructor
     *
     */
    protected BookManagerImpl() {
        this.books = new ArrayList<Book>();
    }

    /**
     * {@inheritdoc}
     */
    public List<Book> getBooks(){
        return this.books;
    }

    /**
     * {@inheritdoc}
     */
    public boolean isValidBookIndex(int bookIndex) {

        if (this.books.size() == 0){
            return false;
        }

        if (bookIndex < 0){
            return false;
        }

        if (bookIndex >= this.books.size()){
            return false;
        }

        return true;
    }

    /**
     * {@inheritdoc}
     */
    public boolean reserveBook(int bookIndex) {
        if (!isValidBookIndex(bookIndex)){
            return false;
        } else {

            Book book = books.get(bookIndex);

            if (book.isReserved()){
                return false;
            }

            book.reserve();
            return true;
        }
    }

    /**
     * {@inheritdoc}
     */
    public String getBookDetails(int bookIndex) {
        return this.books.get(bookIndex).getDetails();
    }

}
