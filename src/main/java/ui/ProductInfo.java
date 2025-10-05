package ui;

public class ProductInfo {
    String name;
    int price, productID;

    public ProductInfo(String name, int price, int productID) {
        this.name = name;
        this.price = price;
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }
}
