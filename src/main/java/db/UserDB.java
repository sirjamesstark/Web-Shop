package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class UserDB {
    public static Collection searchItems(String item_group) {
        Vector v = new Vector();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ProductID, name, price from products");

            while(rs.next()) {
                int i = rs.getInt("ProductID");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                v.addElement(new ProductDB(i, name, price));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return v;
    }

    private UserDB(int userid, String username, int price) {
        super(userid, username, price);
    }
}
