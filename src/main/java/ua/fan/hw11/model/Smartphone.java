package ua.fan.hw11.model;

import java.util.Objects;
import java.util.Random;

public class Smartphone extends Phone {
    private boolean unResponsiveTouchScreen;

    public Smartphone() {
        super();
        unResponsiveTouchScreen = false;
    }

    public Smartphone(int maxBatteryCapacity, boolean undamagedChargingPort, String waterDamageIndicatorColor,
                      boolean unResponsiveTouchScreen) {
        super(maxBatteryCapacity, undamagedChargingPort, waterDamageIndicatorColor);
        this.unResponsiveTouchScreen = unResponsiveTouchScreen;
    }

    public void unlockPhoneUsingFaceID() {
        Random rand = new Random();
        if (rand.nextInt(10) % 2 == 0) {
            System.out.println("Phone is unlocked. Hello, User!");
        } else {
            System.out.println("Can't recognize face! Try again.");
        }
    }

    @Override
    public void phoneTroubleshooting() {
        if (maxBatteryCapacity == 100 && undamagedChargingPort && waterDamageIndicatorColor.equals("White")) {
            System.out.println("There are nо malfunctions!");
        } else {
            if (maxBatteryCapacity != 100) {
                System.out.println("Fixing the battery capacity...");
                maxBatteryCapacity = 100;
            }
            if (!undamagedChargingPort) {
                System.out.println("Fixing the charging port...");
                undamagedChargingPort = true;
            }
            if (!waterDamageIndicatorColor.equals("White")) {
                System.out.println("Fixing water-damaged phone...");
                waterDamageIndicatorColor = "White";
            }
            if (unResponsiveTouchScreen) {
                System.out.println("Fixing the touch screen...");
                unResponsiveTouchScreen = false;
            }
            System.out.println("Troubleshooting completed!");
        }
    }
}
