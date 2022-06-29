package ua.fan.hw28.model;

import lombok.Data;

@Data
public abstract class Product implements IProduct {
    protected long id;
    protected boolean available;
    protected String title;
    protected double price;

    public abstract String generateAddressForNotification();

    @Override
    public String toString() {
        return "Product{" +
                "\n id = " + id +
                "\n available = " + available +
                "\n title = '" + title + '\'' +
                "\n price = " + price +
                "\n}";
    }
}
