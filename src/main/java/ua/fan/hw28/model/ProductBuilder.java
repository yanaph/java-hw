package ua.fan.hw28.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductBuilder {
    private long id;
    private boolean available;
    private String title;
    private double price;
    private String channel;
    private int amount;

    public long getId() {
        return id;
    }

    public ProductBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public ProductBuilder setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProductBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getChannel() {
        return channel;
    }

    public ProductBuilder setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ProductBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public NotifiableProduct buildNotifiableProduct(){
        return new NotifiableProduct(this);
    }

    public ProductBundle buildBundleProduct(){
        return new ProductBundle(this);
    }
}
