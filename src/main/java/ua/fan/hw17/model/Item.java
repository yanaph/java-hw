package ua.fan.hw17.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String name;
    private double cost;

    public Item(double cost, int indexInList) {
        this.name = "item" + indexInList;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name + " - " + String.format("%.2f", cost) + " UAH";
    }
}
