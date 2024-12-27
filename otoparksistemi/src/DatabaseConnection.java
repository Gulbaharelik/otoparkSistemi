

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    // Private constructor Singleton yapısı için
    private DatabaseConnection() {}

    // Singleton metodu
    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/mysql_my", "root", "1234"
                );
                System.out.println("Database Connected!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new SQLException("Database connection failed.");
            }
        }
        return connection;
    }

    public Connection getConnection() {
  return null;  }
}
