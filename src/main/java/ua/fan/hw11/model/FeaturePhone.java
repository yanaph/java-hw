package ua.fan.hw11.model;

import java.util.Objects;

public class FeaturePhone extends Phone {
    private boolean bluetoothConnectionMalfunction;

    public FeaturePhone() {
        super();
        bluetoothConnectionMalfunction = true;
    }

    public FeaturePhone(int maxBatteryCapacity, boolean undamagedChargingPort, String waterDamageIndicatorColor, boolean internetConnection) {
        super(maxBatteryCapacity, undamagedChargingPort, waterDamageIndicatorColor);
        this.bluetoothConnectionMalfunction = internetConnection;
    }

    public void connectToTheInternet(){
        if (!bluetoothConnectionMalfunction){
            System.out.println("Connection completed!");
        } else {
            System.out.println("Bluetooth connection malfunction! Try again or take your phone to phoneTroubleshooting");
        }
    }

    @Override
    public void phoneTroubleshooting() {
        if (maxBatteryCapacity == 100 && undamagedChargingPort && waterDamageIndicatorColor.equals("White")){
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
            if (bluetoothConnectionMalfunction){
                System.out.println("Fixing the bluetooth malfunction...");
                bluetoothConnectionMalfunction = false;
            }
            System.out.println("Troubleshooting completed!");
        }
    }
}
