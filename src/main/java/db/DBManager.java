package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;

    private static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://indra0120.tplinkdns.com:3306/shop", "admin", "password");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static Connection getConnection() {
        return getInstance().con;
    }
}
