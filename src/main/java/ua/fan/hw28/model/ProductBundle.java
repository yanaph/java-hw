package ua.fan.hw28.model;

import lombok.Setter;
import ua.fan.hw28.enums.ProductType;

@Setter
public class ProductBundle extends NotifiableProduct {
    protected int amount;

    public ProductBundle(ProductBuilder builder) {
        super(builder);
        this.amount = builder.getAmount();
    }

    public int getAmountInBundle() {
        return amount;
    }

    @Override
    public ProductType getType() {
        return ProductType.BUNDLE;
    }

    @Override
    public String generateAddressForNotification() {
        throw new UnsupportedOperationException("Bundle can't be notified");
    }

    @Override
    public String toString() {
        return "\nProductBundle{" +
                "\n amount = " + amount +
                "\n channel = '" + channel + '\'' +
                "\n id = " + id +
                "\n available = " + available +
                "\n title = '" + title + '\'' +
                "\n price = " + price +
                "\n}";
    }
}