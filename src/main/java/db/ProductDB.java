package db;

import bo.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
public class ProductDB extends bo.Product {
    public static Collection<ProductDB> searchProducts() {
        ArrayList<ProductDB> list = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ProductID, name, price from products");

            while(rs.next()) {
                int i = rs.getInt("ProductID");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                list.add(new ProductDB(i, name, price));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }


    public static Collection<ProductDB> searchProductsByID(int userID) {
        ArrayList<ProductDB> list = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT  products.ProductID, products.name, products.price\n" +
                    "FROM products\n" +
                    "JOIN shopping_card ON products.productID = shopping_card.productID\n" +
                    "WHERE shopping_card.UserID = '" + userID+"'");

            while(rs.next()) {
                int i = rs.getInt("ProductID");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                list.add(new ProductDB(i, name, price));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    private ProductDB(int productid, String name, int price) {
        super(productid, name, price);
    }
}
