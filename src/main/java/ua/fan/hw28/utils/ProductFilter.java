package ua.fan.hw28.utils;

import ua.fan.hw28.enums.ProductType;
import ua.fan.hw28.model.NotifiableProduct;
import ua.fan.hw28.model.ProductBundle;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {
    public List<NotifiableProduct> filterNotifiableProducts(ProductRepository repository) {
        return repository.getAll()
                .stream()
                .filter(it ->
                        it.getType() == ProductType.NOTIFIABLE)
                .map(it -> (NotifiableProduct) it)
                .collect(Collectors.toList());
    }

    public List<ProductBundle> filterBundleProducts(ProductRepository repository) {
        return repository.getAll()
                .stream()
                .filter(it ->
                        it.getType() == ProductType.BUNDLE)
                .map(it -> (ProductBundle) it)
                .collect(Collectors.toList());
    }
}
