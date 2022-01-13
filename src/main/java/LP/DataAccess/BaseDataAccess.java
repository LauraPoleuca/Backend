package LP.DataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BaseDataAccess {
    String url = "jdbc:mysql://localhost:3306/Music_Store";
    String username = "root";
    String password = "0405";
    Connection connection;

    @Autowired
    public BaseDataAccess() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet ExecuteSelect(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ExecuteCUD(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
