package ui;

public class OrderInfo {
    private int quantity;
    private ProductInfo product;

    public OrderInfo(ProductInfo product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
