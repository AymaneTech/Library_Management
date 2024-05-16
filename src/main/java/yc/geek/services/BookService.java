package yc.geek.services;

import yc.geek.entities.Book;
import yc.geek.repositories.BookRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class BookService {
     private final BookRepository bookRepository;

     public BookService(BookRepository bookRepository) {
          this.bookRepository = bookRepository;
     }

     public List<Book> getAll() {
          return bookRepository.getAll();
     }

     public Book findByIsbn(Long isbn) {
          try {
               return bookRepository.findByIsbn(isbn);
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
     }

     public Book save(Book book) {
          return bookRepository.save(book);
     }

     public boolean update(Book book) {
          try {
               bookRepository.update(book);
          } catch (Exception e) {
               return false;
          }
          return true;
     }

     public boolean delete(Long isbn) {
          try {
               bookRepository.delete(isbn);
          } catch (Exception e) {
               return false;
          }
          return true;
     }
}
