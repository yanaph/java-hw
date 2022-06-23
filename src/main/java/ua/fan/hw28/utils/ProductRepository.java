package ua.fan.hw28.utils;

import ua.fan.hw28.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private final Map<Long, Product> storage = new HashMap<>();

    public void save(Product product) {
        storage.put(product.getId(), product);
    }

    public List<Product> getAll() {
        return new ArrayList<>(storage.values());
    }
}