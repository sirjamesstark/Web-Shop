package bo;

public class Product {
    private String name;
    private int productId, price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(int productId, String name, int price) {
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
}
