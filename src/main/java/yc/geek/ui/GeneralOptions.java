package yc.geek.ui;

import yc.geek.Utils.Print;
import yc.geek.controllers.MainController;

import java.util.Scanner;

public class GeneralOptions {

     private final Scanner scanner;
     public GeneralOptions(Scanner scanner) {
          this.scanner = scanner;
     }

     public int displayMainOptions(){
          Print.log("===========================");
          Print.log("1. Manage the Books: ");
          Print.log("2. Manage Your Books: ");
          Print.log("===========================");
          return Print.readInteger("Enter your option", scanner);
     }

     public int booksOptions() {
          Print.log("==================================");
          Print.log("1. List All Books: ");
          Print.log("2. Find Books By ISBN: ");
          Print.log("3. Create A New Book: ");
          Print.log("4. Update An Existing Book: ");
          Print.log("5. Delete An Existing Book: ");
          Print.log("==================================");
          return Print.readInteger("Enter your option", scanner);
     }

     public int empruntedBooks() {
          Print.log("=======================================================");
          Print.log("1. List All My Untempered Books: ");
          Print.log("2. Emprunt New Book: ");
          Print.log("3. Remove An Existing Book From My Untempered Books: ");
          Print.log("=======================================================");
          return Print.readInteger("Enter your option", scanner);
     }
}
