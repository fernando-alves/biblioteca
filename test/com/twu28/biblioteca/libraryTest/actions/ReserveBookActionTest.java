package com.twu28.biblioteca.libraryTest.actions;

import com.twu28.biblioteca.book.Book;
import com.twu28.biblioteca.library.Library;
import com.twu28.biblioteca.library.actions.ReserveBookAction;
import com.twu28.biblioteca.movie.Movie;
import com.twu28.biblioteca.user.User;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReserveBookActionTest extends TestCase {

        private OutputStream os;
        private PrintStream ps;
        private Library library;

        private final String NEW_LINE = System.getProperty("line.separator");
        private User userFulano;
        private String userFulanoPassword;

        public ReserveBookActionTest() {
            super();
        }

        protected void setUp(){
            this.os = new ByteArrayOutputStream();
            this.ps = new PrintStream(os);
            List<Book> bookList = new ArrayList<Book>();
            bookList.add(new Book("Book A",1));
            bookList.add(new Book("Book B",2));
            bookList.add(new Book("Book C",3));

            List<User> userList = new ArrayList<User>();
            this.userFulanoPassword = "123456";
            this.userFulano = new User("111-2222", userFulanoPassword, "fulano@email.com", "+55 (34) 3342-3411", "Fulano");
            userList.add(userFulano);

            this.library = new Library(bookList, new ArrayList<Movie>(), userList);
        }

        public void testReservationSucceed(){

            library.login(userFulano.getUsername(), userFulanoPassword);

            ReserveBookAction reserveBookAction = new ReserveBookAction(library);
            String validBookId = "1";

            ByteArrayInputStream input = new ByteArrayInputStream(validBookId.getBytes());

            reserveBookAction.execute(input, ps);

            String reservationSucceddMessage = "Thank You! Enjoy the book.";

            assertTrue(os.toString().contains(reservationSucceddMessage));
        }

        public void testReservationNotSuccedd(){

            library.login(userFulano.getUsername(), userFulanoPassword);

            ReserveBookAction reserveBookAction = new ReserveBookAction(library);
            String invalidBookId = "7";

            ByteArrayInputStream input = new ByteArrayInputStream(invalidBookId.getBytes());

            reserveBookAction.execute(input, ps);

            String reservationFailedMessage = "Sorry we don't have that book yet.";

            assertTrue(os.toString().contains(reservationFailedMessage));
        }

        public void testInvalidBookReservation(){

            library.login(userFulano.getUsername(), userFulanoPassword);

            ReserveBookAction reserveBookAction = new ReserveBookAction(library);
            String invalidBook = "invalidBook12223";
            String validBook = "1";

            ByteArrayInputStream userInput = new ByteArrayInputStream(getUserInputForReservation(invalidBook, validBook));

            reserveBookAction.execute(userInput, ps);

            String reservationFailedMessage = "Sorry we don't have that book yet.";

            assertTrue(os.toString().contains(reservationFailedMessage));
        }

        public void testReservationWithoutLogin(){

            library.logout();

            ReserveBookAction reserveBookAction = new ReserveBookAction(library);
            String validBookId = "1";
            ByteArrayInputStream input = new ByteArrayInputStream(validBookId.getBytes());
            reserveBookAction.execute(input, ps);

            assertTrue(os.toString().contains("You must be logged to do this!"));


        }

        public byte[] getUserInputForReservation(String firstBookId, String secondBookId){
            byte[] firstBookByteArray = Arrays.copyOf(firstBookId.getBytes(), firstBookId.getBytes().length + NEW_LINE.getBytes().length);
            System.arraycopy(NEW_LINE.getBytes(), 0, firstBookByteArray, firstBookId.getBytes().length, NEW_LINE.getBytes().length);

            byte[] userInputByteArray = Arrays.copyOf(firstBookByteArray, firstBookByteArray.length + secondBookId.length());
            System.arraycopy(secondBookId.getBytes(),0 , userInputByteArray, firstBookByteArray.length, secondBookId.getBytes().length);

            return userInputByteArray;
        }



}

