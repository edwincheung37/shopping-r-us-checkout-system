package shopping.r.us.checkoutsystem;

/**
 * Buy X Get Y Free Discount
 */
public class BuyXGetYFreeDiscount implements Discount {
    private final String sku;
    private final int x;
    private final int y;

    /**
     *
     * @param sku: product's SKU
     * @param x: for each x quantity of product get paid
     * @param y: enjoy y quantity of product for free
     */
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

