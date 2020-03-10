package shopping.r.us.checkoutsystem;

import java.util.Map;

public class Checkout {
    private final ShoppingCart shoppingCart;
    private final PricingRules pricingRules;

    public Checkout(PricingRules pricingRules) {
        this.shoppingCart = new ShoppingCart();
        this.pricingRules = pricingRules;
    }

    public void scan(String sku) {
        this.shoppingCart.addProduct(sku);
    }

    public double total() {
        double originalTotal = 0;
        for (Map.Entry<String, Integer> entry : this.shoppingCart.getCart().entrySet()) {
            String sku = entry.getKey();
            int qty = entry.getValue();
            double price = Store.getProduct(sku).getPrice();
            originalTotal += price * qty;
        }

        double totalDiscount = 0;
        for (Discount pricingRule : this.pricingRules) {
            totalDiscount += pricingRule.getDiscount(this.shoppingCart);
        }

        return originalTotal - totalDiscount;
    }

    public void reset() {
        this.shoppingCart.clear();
    }
}

