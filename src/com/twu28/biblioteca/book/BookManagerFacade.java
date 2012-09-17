package com.twu28.biblioteca.book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * Interface with all the book's manager expected services.
 *
 *
 */
public interface BookManagerFacade {

    /**
     *
     * Returns the list of books
     *
     * @return the list of books
     */
    public List<Book> getBooks();

    /**
     *
     * Checks if the given bookIndex is valid
     *
     * @param bookIndex the book index
     * @return true, if it is a valid index
     *         false, otherwise
     */
    public boolean isValidBookIndex(int bookIndex);


    /**
     * Reserves a book in the given index
     *
     * @param bookIndex the index of the book
     * @return  true, if reserves succeeded
     *          false, otherwise
     *
     *
     */
    public boolean reserveBook(int bookIndex);

    /**
     * Returns the details of the book in the given index
     *
     * @param bookIndex the book index
     * @return  the details of the book in the given index
     */
    public String getBookDetails(int bookIndex);
}
