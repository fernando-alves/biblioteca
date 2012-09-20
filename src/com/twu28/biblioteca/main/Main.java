package com.twu28.biblioteca.main;

import com.twu28.biblioteca.library.Library;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Library.build().run();
    }
}
