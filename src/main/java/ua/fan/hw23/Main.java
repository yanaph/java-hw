package ua.fan.hw23;

import ua.fan.hw23.utils.DeviceManufactureUtil;
import ua.fan.hw23.utils.TablesCreator;

public class Main {
    public static void main(String[] args) {
        System.out.printf("%n----> Creating and saving tables into database: ");
        TablesCreator.createTable();
        DeviceManufactureUtil.saveFactoryToDataBase();
        DeviceManufactureUtil.saveDeviceToDataBase();
        System.out.printf("%n----> Getting device by index 3: %n%s%n", DeviceManufactureUtil.getDeviceById(3));
        System.out.printf("%n----> Getting factory by index 1: %n%s%n", DeviceManufactureUtil.getFactoryById(2));
        System.out.printf("%n----> Changing device's info (by index 3): %n");
        DeviceManufactureUtil.doubleDevicePriceById(3);
        System.out.printf("%n----> Deleting device by index 3:%n");
        DeviceManufactureUtil.deleteDeviceById(3);
        System.out.printf("%n----> Getting devices by factory Samsung:%n");
        DeviceManufactureUtil.getDevicesByFactoryName("Samsung");
        System.out.printf("%n----> Getting devices grouped by factories:%n");
        DeviceManufactureUtil.getTotalDeviceInfoByFactories();
    }
}
