package ua.fan.hw21.model;

import ua.fan.hw21.annotations.AutoCreate;
import ua.fan.hw21.annotations.Init;
import ua.fan.hw21.annotations.Multiplier;

@AutoCreate
public class AnotherBox {
    @Multiplier
    private final double number = 2.0;

    @Init
    public void printMessage(){
        System.out.println("Method with annotation @Init has been called!");
    }
}
