package shopping.r.us.checkoutsystem;

/**
 * Bundle Discount
 */
public class BundleDiscount implements Discount {
    private final String targetSKU;
    private final String giftSKU;
    private final int targetQty;
    private final int giftQty;

    /**
     *
     * @param targetSKU: target product's SKU
     * @param giftSKU: gift product's SKU
     * @param targetQty: for each targetQty of target product
     * @param giftQty: enjoy giftQty of gift product for free
     */
    public BundleDiscount(String targetSKU, int targetQty, String giftSKU, int giftQty) {
        this.targetSKU = targetSKU;
        this.targetQty = targetQty;
        this.giftSKU = giftSKU;
        this.giftQty = giftQty;
    }

    @Override
    public double getDiscount(ShoppingCart shoppingCart) {
        int targetCartQty = shoppingCart.countProduct(this.targetSKU);
        int giftCartQty = shoppingCart.countProduct(this.giftSKU);
        double giftPrice = Store.getProduct(this.giftSKU).getPrice();
        int giftQty = Math.min(targetCartQty / this.targetQty * this.giftQty, giftCartQty);
        return giftPrice * giftQty;
    }
}