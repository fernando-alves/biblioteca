package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.library.actions.ExitAction;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ExitActionTest extends TestCase {

    public ExitActionTest(){
        super();
    }

    public void testDetailsMessage(){
        ExitAction exitAction = new ExitAction();
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        exitAction.execute(null, ps);

        String expectedExitMessage = "Thank You";
        assertTrue(os.toString().trim().compareTo(expectedExitMessage) == 0);
    }
}
