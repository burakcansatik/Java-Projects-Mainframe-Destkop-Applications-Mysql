package hospitalIdb;



public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/hospitaldb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}