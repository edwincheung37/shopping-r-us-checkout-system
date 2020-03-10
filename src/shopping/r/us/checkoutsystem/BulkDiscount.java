package shopping.r.us.checkoutsystem;

public class BulkDiscount implements Discount {
    private final String sku;
    private final int bulkQty;
    private final double specialPrice;

    public BulkDiscount(String sku, int bulkQty, double specialPrice) {
        this.sku = sku;
        this.bulkQty = bulkQty;
        this.specialPrice = specialPrice;
    }

    @Override
    public double getDiscount(ShoppingCart shoppingCart) {
        int productQty = shoppingCart.countProduct(this.sku);
        double originalPrice = Store.getProduct(this.sku).getPrice();

        if (productQty <= this.bulkQty) {
            return 0;
        }

        return (originalPrice - this.specialPrice) * productQty;
    }

}

