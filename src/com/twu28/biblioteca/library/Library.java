package com.twu28.biblioteca.library;

import com.twu28.biblioteca.book.Book;

import java.util.*;


public class Library {

    private HashMap<Integer, Book> bookMap;

    public Library(List<Book> books) {
        setBookList(books);
    }

    private void setBookList(List<Book> books) {
        this.bookMap = new HashMap<Integer, Book>();
        for (Book book : books){
            bookMap.put(book.getId(), book);
        }
    }

    public boolean reserveBook(String bookId) {

        try {
            int id = Integer.parseInt(bookId);
            if (bookMap.containsKey(id)){
                return bookMap.get(id).reserve();
            }
        } catch (NumberFormatException e) {
            return false;
        }


        return false;
    }

    public Collection<Book> getBooks() {
        return bookMap.values();
    }


}


