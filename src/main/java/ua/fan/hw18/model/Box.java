package ua.fan.hw18.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Box {
    private String from;
    private String material;
    private String color;
    private MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
    private Cargo cargo = new Cargo();
    private LocalDateTime deliveryDate;

    @Override
    public String toString() {
        return "BOX:" +
                "\n from: " + from +
                "\n material: " + material +
                "\n color: " + color +
                "\n maxLiftingCapacity: " + maxLiftingCapacity.getValue() + " " + maxLiftingCapacity.getUnit() +
                "\n cargo: " + cargo.getName() + " " + cargo.getClassOfCargo() +
                "\n deliveryDate: " + deliveryDate;
    }
}