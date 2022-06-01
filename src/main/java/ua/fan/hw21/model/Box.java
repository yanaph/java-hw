package ua.fan.hw21.model;

import lombok.ToString;
import ua.fan.hw21.annotations.AutoCreate;
import ua.fan.hw21.annotations.Init;
import ua.fan.hw21.annotations.Multiplier;

@ToString
@AutoCreate
public class Box {
    @Multiplier
    private final String name = "hello";
    @Multiplier (action = Multiplier.Action.MULTIPLICATION)
    private final Double size = 3.0;
    @Multiplier (action = Multiplier.Action.ADDITION)
    private final Double size2 = 3.0;
    @Multiplier
    private final Double size3 = 3.0;
    private final Integer weight = 2;

    @Init
    public void init() {
        System.out.println("Method with annotation @Init has been called!");
    }
}
