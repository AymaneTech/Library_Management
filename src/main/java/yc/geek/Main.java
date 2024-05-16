package yc.geek;


import yc.geek.controllers.MainController;
import yc.geek.mappers.BookMapper;
import yc.geek.repositories.BookRepository;
import yc.geek.services.BookService;
import yc.geek.ui.BookOptions;
import yc.geek.ui.GeneralOptions;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

     public static void main(String[] args) throws SQLException {
          Scanner sc = new Scanner(System.in);
          MainController mainController = new MainController(new GeneralOptions(sc), new BookOptions(sc));
          mainController.displayMenu();
     }
}
