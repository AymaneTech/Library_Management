package yc.geek.controllers;

import lombok.AllArgsConstructor;
import yc.geek.Utils.Print;
import yc.geek.entities.Book;
import yc.geek.mappers.BookMapper;
import yc.geek.repositories.BookRepository;
import yc.geek.services.BookService;
import yc.geek.ui.BookOptions;
import yc.geek.ui.GeneralOptions;

@AllArgsConstructor
public class MainController {

     private GeneralOptions generalOptions;
     private BookOptions bookOptions;
     private BookService bookService;

     public MainController(GeneralOptions generalOptions, BookOptions bookOptions) {
          this.generalOptions = generalOptions;
          this.bookOptions = bookOptions;
          this.setBookService();
     }


     private void setBookService() {
          try {
               new BookService(new BookRepository(new BookMapper()));
          }catch (Exception e){
               throw new RuntimeException(e);
          }
     }

     public void displayMenu() {
          int option = generalOptions.displayMainOptions();
          handleUserAction(option);
     }

     private void handleUserAction(int option) {
          switch (option) {
               case 1 -> handleBookOptions(generalOptions.booksOptions());
               case 2 -> handleEmpruntedBooksOptions(generalOptions.empruntedBooks());
          }
     }

     private void handleBookOptions(int option) {
          switch (option) {
               case 1:
                    Book book = bookOptions.create();
                    bookService.save(book);
                    Print.log("book created successfully");
          }

     }

     private void handleEmpruntedBooksOptions(int option) {

     }
}

