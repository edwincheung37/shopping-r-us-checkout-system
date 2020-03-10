package shopping.r.us.checkoutsystem;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<String, Integer> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void addProduct(String sku) {
        this.cart.put(sku, countProduct(sku) + 1);
    }

    public void removeProduct(String sku) {
        this.cart.remove(sku);
    }

    public int countProduct(String sku) {
        return this.cart.containsKey(sku) ? this.cart.get(sku) : 0;
    }

    public Map<String, Integer> getCart() {
        return this.cart;
    }

    public void clear() {
        this.cart.clear();
    }
}

