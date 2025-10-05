package bo;

import db.OrderDB;

import java.util.Collection;

public class Order {
    private Product product;
    private int quantity;

    public static Collection<Order> searchOrders(int userID) {
        return OrderDB.searchOrders(userID);
    }

    public static boolean addToCart(int userId, int productId) {
        return OrderDB.addOrder(userId, productId);
    }

    protected Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
