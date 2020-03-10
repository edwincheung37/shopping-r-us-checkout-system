package shopping.r.us.checkoutsystem;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {
    private static final double DELTA = 1e-15;
    private static PricingRules pricingRules;

    @BeforeClass
    public static void beforeClass() {
        Store.addProduct(new Product("ipd", "Super iPad", 549.99));
        Store.addProduct(new Product("mbp", "MacBook Pro", 1399.99));
        Store.addProduct(new Product("atv", "Apple TV", 109.5));
        Store.addProduct(new Product("vga", "VGA adapter", 30));

        pricingRules = new PricingRules();
        pricingRules.addDiscount(new BuyXGetYFreeDiscount("atv", 3, 1));
        pricingRules.addDiscount(new BulkDiscount("ipd", 4, 499.99));
        pricingRules.addDiscount(new BundleDiscount("mbp", 1, "vga", 1));
    }

    @Test
    public void testcase1() {
        Checkout co = new Checkout(pricingRules);

        co.scan("atv");
        co.scan("atv");
        co.scan("atv");
        co.scan("vga");

        assertEquals(co.total(), 249.0, DELTA);
    }

    @Test
    public void testcase2() {
        Checkout co = new Checkout(pricingRules);

        co.scan("atv");
        co.scan("ipd");
        co.scan("ipd");
        co.scan("atv");
        co.scan("ipd");
        co.scan("ipd");
        co.scan("ipd");

        assertEquals(co.total(), 2718.95, DELTA);
    }

    @Test
    public void testcase3() {
        Checkout co = new Checkout(pricingRules);

        co.scan("mbp");
        co.scan("vga");
        co.scan("ipd");

        assertEquals(co.total(), 1949.98, DELTA);
    }

}

