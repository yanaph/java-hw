package ua.fan.hw28.model;

import lombok.Setter;
import ua.fan.hw28.enums.ProductType;

import java.util.Random;


@Setter
public class NotifiableProduct extends Product {
    private final static Random RANDOM = new Random();
    protected String channel;

    public NotifiableProduct(ProductBuilder builder) {
        this.id = builder.getId();
        this.available = builder.isAvailable();
        this.title = builder.getTitle();
        this.price = builder.getPrice();
        this.channel = builder.getChannel();
    }

    public String generateAddressForNotification() {
        return "user" + RANDOM.nextInt(500)+ "@gmail.com";
    }

    @Override
    public String toString() {
        return "\nNotifiableProduct{" +
                "\n channel = '" + channel + '\'' +
                "\n id = " + id +
                "\n available = " + available +
                "\n title = '" + title + '\'' +
                "\n price = " + price +
                "\n}";
    }

    @Override
    public ProductType getType() {
        return ProductType.NOTIFIABLE;
    }
}
