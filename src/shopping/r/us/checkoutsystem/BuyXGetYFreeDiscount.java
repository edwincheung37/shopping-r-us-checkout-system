package shopping.r.us.checkoutsystem;

public class BuyXGetYFreeDiscount implements Discount {
    private final String sku;
    private final int x;
    private final int y;

    public BuyXGetYFreeDiscount(String sku, int x, int y) {
        this.sku = sku;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getDiscount(ShoppingCart shoppingCart) {
        int freeQty = shoppingCart.countProduct(this.sku) / this.x * this.y;
        double price = Store.getProduct(this.sku).getPrice();
        return price * freeQty;
    }
}

