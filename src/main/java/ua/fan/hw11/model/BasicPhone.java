package ua.fan.hw11.model;

import lombok.Setter;

import java.util.Objects;
import java.util.Scanner;

public class BasicPhone extends Phone {
    private boolean snakeGame;

    public BasicPhone() {
        super();
        snakeGame = false;
    }

    public BasicPhone(int maxBatteryCapacity, boolean undamagedChargingPort, String waterDamageIndicatorColor, boolean snakeGame) {
        super(maxBatteryCapacity, undamagedChargingPort, waterDamageIndicatorColor);
        this.snakeGame = snakeGame;
    }

    public void playSnake() {
        if (!snakeGame) {
            System.out.println("There is no Snake game on the phone");
        } else {
            System.out.println("Playing...");
        }
    }
}
