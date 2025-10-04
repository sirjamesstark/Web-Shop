package bo;

import ui.ProductInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProductHandler {
    public static Collection<ProductInfo> getProducts() {
        Collection list = Product.searchProducts();
        ArrayList<ProductInfo> products = new ArrayList<>();
        for (Iterator it = list.iterator();  it.hasNext(); ) {
            Product product = (Product) it.next();
            products.add(new ProductInfo(product.getName(), product.getPrice()));
        }
        return products;
    }
}
