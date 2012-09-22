package com.twu28.biblioteca.libraryTest;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest extends TestCase {


    public LibraryTest(){
        super();
    }

    public void testLibraryBookList(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book A",1));
        bookList.add(new Book("Book B",2));
        bookList.add(new Book("Book C",3));

        Library library = new Library(bookList);

        for (Book book : bookList){
            assertTrue(library.getBooks().contains(book));
        }

    }

    public void testDiferentBookList(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book A",1));
        bookList.add(new Book("Book B",2));
        bookList.add(new Book("Book C",3));

        Library library = new Library(bookList);

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

        Library library = new Library(bookList);

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

        Library library = new Library(bookList);

        assertFalse(library.reserveBook(String.valueOf(bookA.getId())));
        assertFalse(library.reserveBook(String.valueOf(bookB.getId())));

    }

    public void testReserveInvalidBook(){
        List<Book> bookList = new ArrayList<Book>();
        Book bookA = new Book("Book A",1);
        Book bookB = new Book("Book B",2);

        bookList.add(bookA);
        bookList.add(bookB);

        Library library = new Library(bookList);

        Book invalidBook = new Book("Book C", 3);

        assertFalse(library.reserveBook(String.valueOf(invalidBook.getId())));
    }


}
