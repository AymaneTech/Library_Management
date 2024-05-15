package yc.geek.mappers;

import yc.geek.Utils.Print;
import yc.geek.entities.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {

     public Book toObject(ResultSet resultSet) {
          Book book = new Book();
          try {
               book.setISBN(resultSet.getLong("isbn"));
               book.setTitle(resultSet.getString("title"));
               book.setAuthor(resultSet.getString("author"));
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }
          return book;
     }

     public PreparedStatement preparedStatement(Book book, PreparedStatement preparedStatement) {

          try {
               preparedStatement.setLong(1, book.getISBN());
               preparedStatement.setString(2, book.getTitle());
               preparedStatement.setString(3, book.getAuthor());
          } catch (SQLException e) {
               Print.log(e.getMessage());
          }
          return preparedStatement;
     }
}
