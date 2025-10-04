package db;

import bo.Product;
import bo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class OrderDB extends bo.Order {
    public static Collection searchItems(String item_group, int userID) {
        Vector<Product> v = new Vector<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT  ProductID, name, price\n" +
                    "FROM products\n" +
                    "JOIN shopping_card ON users.UserID = shopping_card.UserID\n" +
                    "WHERE UserID = " + "userID");

            while(rs.next()) {
                int i = rs.getInt("ProductID");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                v.addElement(new Product(i, name, price));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return v;
    }

    private OrderDB(int orderID, User user, Vector<Product> products) {
        super(orderID, user, products);
    }
}
