package ua.fan.hw26.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter

public class Order {
    private String id;
    private List<String> itemsId;
    private LocalDate date;
    private String customerId;

    public Order(int year, int month, int day) {
        id = UUID.randomUUID().toString();
        date = LocalDate.of(year,month,day);
    }
}
