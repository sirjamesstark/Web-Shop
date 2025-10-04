package db;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBManager {
    private static Connection con = null;

    private DBManager() {}

    public static Connection getConnection() {
        if( con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://indra0120.tplinkdns.com:3306/shop", "admin", "password");
            } catch (Exception e) { e.printStackTrace(); }
        }
        return con;
    }
}
