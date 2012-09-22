package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.actions.ShowBookListAction;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ShowBookListActionTest extends TestCase{

    private static final String NEW_LINE = System.getProperty("line.separator");
    private OutputStream os;
    private PrintStream ps;

    public ShowBookListActionTest(){
        super();
    }

    public void setUp(){
        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);
    }

    public void testBookList(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book A",1));
        bookList.add(new Book("Book B",2));
        bookList.add(new Book("Book C",3));

        Library library = new Library(bookList);

        ShowBookListAction showBookListAction = new ShowBookListAction(library);
        showBookListAction.execute(null, ps);

        String expectedBookList = "1 - Book A"+NEW_LINE+
                "2 - Book B"+NEW_LINE+
                "3 - Book C";

        assertTrue(os.toString().trim().compareTo(expectedBookList) == 0);
    }

}
