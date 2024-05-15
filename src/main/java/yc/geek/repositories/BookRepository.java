package yc.geek.repositories;

import com.sun.jdi.event.StepEvent;
import yc.geek.Utils.Print;
import yc.geek.database.DBConnection;
import yc.geek.entities.Book;
import yc.geek.mappers.BookMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
     final Connection db;
     final BookMapper bookMapper;
     private Book book;

     public BookRepository(BookMapper bookMapper) throws SQLException {
          this.bookMapper = bookMapper;
          db = DBConnection.getInstance().getConnection();
     }

     public List<Book> getAllBooks() {
          List<Book> books = new ArrayList<>();
          String query = "SELECT * FROM books";
          try {
               PreparedStatement statement = db.prepareStatement(query);
               ResultSet resultSet = statement.executeQuery();

               while (resultSet.next()) {
                    Book book = bookMapper.toObject(resultSet);
                    books.add(book);
               }
               resultSet.close();
               statement.close();
          } catch (Exception e) {
               Print.log(e.getMessage());
          }
          return books;
     }

     public Book save(Book book) {
          String query = "INSERT INTO books (isbn, title, author) VALUES (?,?,?)";
          try (PreparedStatement statement = bookMapper.preparedStatement(book, db.prepareStatement(query))) {

               int affectedRows = statement.executeUpdate();

               if (affectedRows == 0) {
                    throw new SQLException("Failed to create book, (this is message is from geek)");
               }
          } catch (SQLException e) {
               System.out.println(e.getMessage());
          }
          return book;
     }

     public Book findByIsbn(Long isbn) throws SQLException {
          String query = "SELECT * FROM books WHERE isbn = ?";
          PreparedStatement statement = null;
          ResultSet resultSet = null;
          try {
               statement = db.prepareStatement(query);
               statement.setLong(1, isbn);
               resultSet = statement.executeQuery();
               if (!resultSet.next()) {
                    throw new SQLException("Failed to find book with isbn " + isbn);
               }
               this.book = bookMapper.toObject(resultSet);
          } finally {
               // Close the ResultSet and PreparedStatement in the finally block
               if (resultSet != null) {
                    resultSet.close();
               }
               if (statement != null) {
                    statement.close();
               }
          }
          return this.book;
     }


     public void update(Book book) throws SQLException {
          String query = "UPDATE books SET title = ?, author = ? WHERE isbn = ?";
          try (PreparedStatement statement = bookMapper.preparedStatement(book, db.prepareStatement(query))) {
               statement.executeUpdate();
               statement.close();
          }
     }

     public void delete(Long isbn) throws SQLException {
          String query = "DELETE FROM books WHERE isbn = ?";
          try (PreparedStatement statement = db.prepareStatement(query)) {
               statement.setLong(1, isbn);
               int affectedRows = statement.executeUpdate();
               if (affectedRows != 1) {
                    throw new SQLException("Failed to delete book with isbn " + isbn);
               }
          }
     }
}
