package com.twu28.biblioteca.main;

import com.twu28.biblioteca.library.Library;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            Library.build().run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
