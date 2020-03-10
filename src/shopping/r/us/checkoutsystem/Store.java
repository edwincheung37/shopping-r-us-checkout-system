package shopping.r.us.checkoutsystem;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private static final Map<String, Product> productList = new HashMap<>();

    public static Product getProduct(String sku) {
        return productList.get(sku);
    }

    public static void addProduct(Product product) {
        productList.put(product.getSKU(), product);
    }

    public static void removeProduct(String sku) {
        productList.remove(sku);
    }

    public static boolean containsProduct(String sku) {
        return productList.containsKey(sku);
    }

    public static void reset() {
        productList.clear();
    }

}


