package ua.fan.hw28.factory;


import ua.fan.hw28.model.Product;
import ua.fan.hw28.model.ProductBuilder;

import java.util.Random;

public class ProductFactory {
    private final static Random RANDOM = new Random();

    public Product generateRandomProduct() {
        if (RANDOM.nextBoolean()) {
            return new ProductBuilder()
                    .setAmount(RANDOM.nextInt(15))
                    .setAvailable(RANDOM.nextBoolean())
                    .setChannel(RANDOM.nextBoolean() + "" + RANDOM.nextDouble())
                    .setPrice(RANDOM.nextDouble())
                    .setId(RANDOM.nextLong())
                    .setTitle(RANDOM.nextFloat() + "" + RANDOM.nextDouble())
                    .buildBundleProduct();
        } else {
            return new ProductBuilder()
                    .setId(RANDOM.nextLong())
                    .setTitle(RANDOM.nextFloat() + "" + RANDOM.nextDouble())
                    .setAvailable(RANDOM.nextBoolean())
                    .setChannel(RANDOM.nextBoolean() + "" + RANDOM.nextDouble())
                    .setPrice(RANDOM.nextDouble())
                    .buildNotifiableProduct();
        }
    }
}
