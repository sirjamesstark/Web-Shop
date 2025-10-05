package db;

import bo.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class OrderDB extends bo.Order {
    public static Collection searchOrders(int userID) {
        ArrayList<OrderDB> list = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT  products.ProductID, products.name, products.price, shopping_card.quantity\n" +
                    "FROM products\n" +
                    "JOIN shopping_card ON products.productID = shopping_card.productID\n" +
                    "WHERE shopping_card.UserID = '" + userID+"'");
            ArrayList<ProductDB> userProducts = (ArrayList<ProductDB>) ProductDB.searchProductsByID(userID);

            for (int i = 0; rs.next(); i++) {
                int quantity = rs.getInt("quantity");
                list.add(new OrderDB(userProducts.get(i), quantity));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public static boolean addOrder(int userID, int productID) {
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO shopping_card (userID, productID, quantity)" +
                    "VALUES (" + userID + ", " + productID + ", 1 )" +
                    "ON DUPLICATE KEY UPDATE quantity = quantity + 1");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private OrderDB(Product product, int quantity) {
        super(product, quantity);
    }
}
