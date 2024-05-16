package yc.geek.ui;

import lombok.AllArgsConstructor;
import yc.geek.Utils.Print;
import yc.geek.entities.Book;

import java.util.Scanner;

@AllArgsConstructor
public class BookOptions {
     private final Scanner scanner;

     public Book create() {
          Long isbn = Print.readLong("ISBN", scanner);
          String title = Print.readString("Title", scanner);
          String author = Print.readString("Author", scanner);
          return new Book(isbn, title, author);
     }



}
