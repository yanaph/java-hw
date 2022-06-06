package ua.fan.hw23.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factory {
    String id;
    String name;
    String country;

    @Override
    public String toString() {
        return "Factory{" +
                "\nid: " + id +
                "\nname: " + name +
                "\ncountry: " + country +
                '}';
    }
}
