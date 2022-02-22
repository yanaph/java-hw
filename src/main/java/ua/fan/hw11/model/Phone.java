package ua.fan.hw11.model;


import java.util.Objects;

public abstract class Phone {
    protected int maxBatteryCapacity; //in %
    protected boolean undamagedChargingPort;
    protected String waterDamageIndicatorColor;

    public Phone() {
        maxBatteryCapacity = 100;
        undamagedChargingPort = true;
        waterDamageIndicatorColor = "White";
    }

    public Phone(int maxBatteryCapacity, boolean undamagedChargingPort, String waterDamageIndicatorColor) {
        this.maxBatteryCapacity = maxBatteryCapacity;
        this.undamagedChargingPort = undamagedChargingPort;
        this.waterDamageIndicatorColor = waterDamageIndicatorColor;
    }

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
            System.out.println("Troubleshooting completed!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return maxBatteryCapacity == phone.maxBatteryCapacity && undamagedChargingPort == phone.undamagedChargingPort && Objects.equals(waterDamageIndicatorColor, phone.waterDamageIndicatorColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxBatteryCapacity, undamagedChargingPort, waterDamageIndicatorColor);
    }

    public void compare(Phone phone) {
        if (this.hashCode() == phone.hashCode()) {
            System.out.println(this.equals(phone));
        } else {
            System.out.println(false);
        }
    }
}