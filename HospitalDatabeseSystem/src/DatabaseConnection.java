import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/HospitalDB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına bağlantı başarılı!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Veritabanına bağlantı başarısız!");
        }
        return connection;
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL JDBC sürücüsü bulunamadı!");
        }
    }
}
