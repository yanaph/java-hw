package ua.fan.hw23.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Device {
    Integer id;
    String type;
    String modelName;
    Integer price;
    LocalDate manufactureDate;
    String description;
    Boolean inStock;
    String factoryId;

    public Device(String type, String modelName, Integer price, LocalDate manufactureDate, String description, Boolean inStock, String factoryId) {
        this.type = type;
        this.modelName = modelName;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.description = description;
        this.inStock = inStock;
        this.factoryId = factoryId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "\nid: " + id +
                "\ntype: " + type +
                "\nmodel: " + modelName +
                "\nprice: " + price +
                "\nmanufacture date: " + manufactureDate +
                "\ndescription: " + description +
                "\nin Stock:b" + (inStock ? "yes" : "no") +
                "\nfactory id: '" + factoryId +
                '}';
    }
}
