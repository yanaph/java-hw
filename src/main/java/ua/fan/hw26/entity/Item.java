package ua.fan.hw26.entity;

import com.mongodb.lang.NonNull;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Item {
    private String id;
    private String name;
    @NonNull
    private Double price;
    private int quantity;

    public Item(String name, @NonNull Double price, int quantity) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
