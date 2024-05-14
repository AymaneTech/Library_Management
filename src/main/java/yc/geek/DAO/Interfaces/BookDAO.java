package yc.geek.DAO.Interfaces;

import java.util.List;

import yc.geek.Database.Entities.Book;

/**
 * BookDAO
 */
public interface BookDAO {

  public List<Book> getAll();
  public Book create(BookDTO);
}
