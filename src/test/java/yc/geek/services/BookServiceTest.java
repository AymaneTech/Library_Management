package yc.geek.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yc.geek.entities.Book;
import yc.geek.mappers.BookMapper;
import yc.geek.repositories.BookRepository;

import java.sql.SQLException;

class BookServiceTest {
     private BookService bookService;

     @BeforeEach
     void setUp() throws SQLException {
          BookRepository bookRepository = new BookRepository(new BookMapper());
          bookService = new BookService(bookRepository);
     }

     @Test
     @DisplayName("test creating new book")
     void testCreateNewBook() throws SQLException {
          Book expected = new Book(2822L, "title 1", "author 1");

          Book actual = bookService.save(expected);

          assertEquals(expected.getISBN(), actual.getISBN());
          assertEquals(expected.getTitle(), actual.getTitle());
          assertEquals(expected.getAuthor(), actual.getAuthor());
     }

     @Test
     @DisplayName("test fetching all books")
     void testFetchAllBooks() throws SQLException {
          
     }
}
