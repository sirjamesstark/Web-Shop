package bo;

import db.ProductDB;

import java.util.Collection;

public class Product {
    private String name;
    private int productId, price;

    public static Collection searchProducts() {
        return ProductDB.searchProducts();
    }

    protected Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    protected Product(int productId, String name, int price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getProductID() {
        return productId;
    }
}
