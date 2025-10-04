package bo;

import java.util.ArrayList;
import java.util.Collection;

public class User {
    private String username, password;
    private int userID;
    private ArrayList<Order> cart;

    protected User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected User(int userid, String username, String password) {
        this.userID = userid;
        this.username = username;
    }

    protected User(int userid, String username) {
        this.userID = userid;
        this.username = username;
    }

    public void getOrders() {
        Collection<Order> list = Order.searchOrders(userID);
        cart.addAll(list);
    }

    public String getUsername() {
        return username;
    }

    public int getUserID() {
        return userID;
    }

    public ArrayList<Order> getCart() {
        return cart;
    }

    public String getPassword() {
            return password;
    }

}
