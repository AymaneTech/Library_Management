package yc.geek.Utils;

import java.util.Scanner;

public class Print {
  Scanner scanner = new Scanner(System.in);

  public static void log(String text){
    System.out.println("\t\t\t" + text);
  }
  public static String readString(String key, Scanner scanner){
    scanner.nextLine();
    System.out.println("\t\t\t" + key + ":  ");
    return scanner.nextLine();
  }

  public static Integer readInteger(String key, Scanner scanner){
    System.out.print("\t\t\t" + key + ":  ");
    return scanner.nextInt();
  }

  public static Long readLong(String key, Scanner scanner){
    System.out.print("\t\t\t" + key + ":  ");
    Long result = scanner.nextLong();
    scanner.nextLine();
    return result;
  }

}
