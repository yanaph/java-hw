package ua.fan.hw24.service;

import ua.fan.hw24.model.Device;
import ua.fan.hw24.model.Factory;

import java.util.Locale;
import java.util.Random;

public class DeviceService {
    private final static Random RANDOM = new Random();

    public Device createDevice(String type,String modelName, String description, boolean inStock, Factory factory) {
        return new Device(type, modelName, RANDOM.nextInt(1000), description, inStock, factory);
    }


}
