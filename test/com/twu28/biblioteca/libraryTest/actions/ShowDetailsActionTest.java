package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.library.actions.ShowDetailsAction;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ShowDetailsActionTest extends TestCase {

    private OutputStream os;
    private PrintStream ps;

    public ShowDetailsActionTest(){
        super();
    }

    public void setUp(){
        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);
    }

    public void testDetailsMessage(){
        ShowDetailsAction showDetailsAction = new ShowDetailsAction();
        showDetailsAction.execute(null, ps);

        String expectedDetailsMessage = "Please talk to Librarian. Thank you.";
        assertTrue(os.toString().trim().compareTo(expectedDetailsMessage) == 0);
    }
}
