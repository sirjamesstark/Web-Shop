package bo;

import db.UserDB;
import ui.OrderInfo;
import ui.ProductInfo;
import ui.UserInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UserHandler {
    private static User user;
    public static UserInfo getUser(String username, String password) {
        user = UserDB.loginAccount(username, password);
        if (user != null) {
            return new UserInfo(user.getUserID(), user.getUsername());
        }
        return null;
    }

    public static Collection<OrderInfo> getOrders() {
        Collection list = Order.searchOrders(user.getUserID());
        ArrayList<OrderInfo> orders = new ArrayList<>();
        for (Iterator it = list.iterator();  it.hasNext(); ) {
            Order order = (Order) it.next();
            orders.add(new OrderInfo(new ProductInfo(order.getProduct().getName(), order.getProduct().getPrice()), order.getQuantity()));
        }
        return orders;
    }
}
