package com.twu28.biblioteca.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {

    protected List<Book> books;
    private static final String DEFAULT_BOOK_FILE = "bookList.txt";

    public BookManager() throws FileNotFoundException {
        buildBookList();
    }

    public BookManager (List<Book> books) {
        setBooks(books);
    }

    private void setBooks(List<Book> bookList) {
       this.books = new ArrayList<Book>();
       this.books.addAll(bookList);

    }

    private void buildBookList() throws FileNotFoundException {
        this.books = new ArrayList<Book>();
        try {
           Scanner sc = new Scanner(new File(DEFAULT_BOOK_FILE));
           while(sc.hasNextLine()){
               books.add(new Book(sc.nextLine()));
           }
        } catch (FileNotFoundException e) {
            throw e;
        }

    }

    public List<Book> getBooks(){
        return this.books;
    }

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

    public String getBookDetails(int bookIndex) {
        return this.books.get(bookIndex).getDetails();
    }


}
