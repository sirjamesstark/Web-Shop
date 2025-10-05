package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class UserDB extends bo.User {
    public static UserDB loginAccount(String username, String password){
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT UserID, username FROM users WHERE username = '" + username + "' AND password_hash = '" + password+"'");
            if(rs.next())
                return new UserDB(rs.getInt("UserID"), username);
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    private UserDB(int userID, String username) {
        super(userID, username);
    }
}
