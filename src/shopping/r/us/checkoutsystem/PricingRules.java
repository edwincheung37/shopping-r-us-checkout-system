package shopping.r.us.checkoutsystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PricingRules implements Iterable<Discount> {
    private final List<Discount> pricingRules;

    public PricingRules() {
        this.pricingRules = new ArrayList<>();
    }

    public void addDiscount(Discount discount) {
        this.pricingRules.add(discount);
    }

    @Override
    public Iterator<Discount> iterator() {
        return this.pricingRules.iterator();
    }
}

