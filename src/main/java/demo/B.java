package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BadUserDao {

    public String findUserByName(Connection connection, String username) throws SQLException {
        // BAD: SQL query built using string concatenation
        String query = "SELECT username FROM users WHERE username = '" + username + "'";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("username");
            }
            return null;
        }
    }
}
