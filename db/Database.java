import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Database";
    private static final String USER = "root";
    private static final String PASSWORD = "Jstn_Mgl1210";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
