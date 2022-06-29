package ua.fan.hw28;

import ua.fan.hw28.factory.ProductFactory;
import ua.fan.hw28.model.NotifiableProduct;
import ua.fan.hw28.model.Product;
import ua.fan.hw28.model.ProductBundle;
import ua.fan.hw28.utils.ProductFilter;
import ua.fan.hw28.utils.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        ProductFilter filter = new ProductFilter();
        ProductFactory generator = new ProductFactory();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            products.add(generator.generateRandomProduct());
        }
        products.forEach(repository::save);

        System.out.println(repository.getAll());

        List<ProductBundle> productBundles = filter.filterBundleProducts(repository);
        if (productBundles.size() > 0){
            int sum = 0;
            for (ProductBundle productBundle : productBundles) {
                sum += productBundle.getAmountInBundle();
            }
            System.out.println("\n\nThere are " + sum + " bundles in total");
        } else {
            System.out.println("\n\nThere is no bundle products");
        }


        List<NotifiableProduct> notifiableProducts = filter.filterNotifiableProducts(repository);
        if (notifiableProducts.size() > 0) {
            List<String> emails = new ArrayList<>();
            for (NotifiableProduct notifiableProduct : notifiableProducts) {
                for (int i = 0; i < 3; i++) {
                    emails.add(notifiableProduct.generateAddressForNotification());
                }
            }
            System.out.println("\nNotifications sent: " + emails.size());
            System.out.println("to this emails: ");
            for (String email : emails) {
                System.out.println(" -> " + email);
            }
        } else {
            System.out.println("\nThere's no notifiable products, so no emails were sent.");
        }
    }
}
