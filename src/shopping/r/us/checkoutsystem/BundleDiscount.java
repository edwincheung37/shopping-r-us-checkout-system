package shopping.r.us.checkoutsystem;

public class BundleDiscount implements Discount {
    private final String targetSKU;
    private final String bundleSKU;
    private final int targetQty;
    private final int bundleQty;

    public BundleDiscount(String targetSKU, int targetQty, String bundleSKU, int bundleQty) {
        this.targetSKU = targetSKU;
        this.targetQty = targetQty;
        this.bundleSKU = bundleSKU;
        this.bundleQty = bundleQty;
    }

    @Override
    public double getDiscount(ShoppingCart shoppingCart) {
        int targetCartQty = shoppingCart.countProduct(this.targetSKU);
        int bundleCartQty = shoppingCart.countProduct(this.bundleSKU);
        double bundlePrice = Store.getProduct(this.bundleSKU).getPrice();
        int freeBundleQty = Math.min(targetCartQty / this.targetQty * this.bundleQty, bundleCartQty);
        return bundlePrice * freeBundleQty;
    }
}