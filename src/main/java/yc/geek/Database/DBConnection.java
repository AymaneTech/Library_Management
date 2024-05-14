package yc.geek.Database;

import yc.geek.Utils.Print;

public class Connection {

  public static Connection instance = null;
  private Connection connection = null;

  private void init () {
    final String url = "jdbc:pgsql//localhost/5432/org";
    final String username = "postgres";
    final String password = "admin";

    connection = DatabaseManager.getConnection(url, username, password);

    Print.log("the connection set with success !");
  }

  public Connection getConnection () {
      return connection;
  }

  public static Connection getInstance() {
    if(instance != null && !instance.getConnection().isClosed()) {
        return instance;
    } else {
        new Connection();
        instance.init();
    }
}
