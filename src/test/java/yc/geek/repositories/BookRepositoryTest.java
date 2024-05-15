package yc.geek.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yc.geek.database.DBConnection;
import yc.geek.entities.Book;
import yc.geek.mappers.BookMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookRepositoryTest {
     private BookRepository bookRepository;

     @BeforeEach
     void setUp() throws SQLException {
          bookRepository = new BookRepository(new BookMapper());
     }

     @AfterEach
     void tearDown() {
          try {
               Connection connection = DBConnection.getInstance().getConnection();
               Statement statement = connection.createStatement();
               statement.executeUpdate("DELETE FROM books");
          } catch (SQLException e) {
               e.printStackTrace();
          }
     }

     @Test
     void shouldInsertAndRetrieveBookByIsbn() throws SQLException {
          // Arrange
          Book expected = new Book(97979L, "hello book", "author");

          // Act
          bookRepository.save(expected);
          Book actual = bookRepository.findByIsbn(expected.getISBN());

          // Assert
          assertEquals(expected.getISBN(), actual.getISBN(), "ISBNs should match");
     }

     @Test
     void shouldThrowExceptionWhenFindingNonexistentBook() {
          // Arrange - No need to insert a book since we are testing a negative case

          // Act & Assert
          assertThrows(SQLException.class, () -> {
               bookRepository.findByIsbn(979979L);
          }, "Exception should be thrown when book is not found");
     }

     @Test
     void shouldDeleteBookByIsbn() throws SQLException {
          // Arrange
          Book book = new Book(1234567890L, "Test Book", "Test Author");
          bookRepository.save(book);

          // Act
          bookRepository.delete(1234567890L);

          // Assert
          assertThrows(SQLException.class, () -> {
               bookRepository.findByIsbn(1234567890L);
          }, "Exception should be thrown when trying to find deleted book by ISBN");
     }

     @Test
     void shouldThrowExceptionWhenDeletingNonexistentBook() {
          // Arrange - No need to insert a book since we are testing a negative case
          // Act & Assert
          assertThrows(SQLException.class, () -> {
               bookRepository.delete(9999999999L);
          }, "Exception should be thrown when deleting nonexistent book by ISBN");
     }
}
