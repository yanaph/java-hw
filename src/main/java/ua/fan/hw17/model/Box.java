package ua.fan.hw17.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Box {
    private List<Item> itemList;
    private double size;

    @Override
    public String toString() {
        return "Box with size " + String.format("%.2f",size) + " sq.m.: "
                + itemList;
    }
}
