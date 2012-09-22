package com.twu28.biblioteca.library.actions;

import java.io.InputStream;
import java.io.PrintStream;

public interface LibraryActionInterface {
    public void execute(InputStream input, PrintStream output);
}
