package ua.fan.hw21.model;

import lombok.ToString;
import ua.fan.hw21.annotations.AutoCreate;
import ua.fan.hw21.annotations.Init;
import ua.fan.hw21.annotations.Multiplier;

@ToString
@AutoCreate
public class AnotherBox {
    @Multiplier
    private final Integer number = 2;

    @Init
    public void printMessage(){
        System.out.println("Method with annotation @Init has been called!");
    }
}
