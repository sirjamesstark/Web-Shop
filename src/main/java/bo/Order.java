package bo;

import java.util.Vector;

public class Order {
    int orderID;
    private final User user;
    private Vector<Product> products;

    public Order(User user, Vector<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Order(int orderID, User user, Vector<Product> products) {
        this.orderID = orderID;
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public Vector<Product> getProducts() {
        return products;
    }
}
