package ua.fan.hw24.service;

import ua.fan.hw24.model.Device;
import ua.fan.hw24.model.Factory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FactoryService {
    private final static Random RANDOM = new Random();
    public Factory createFactory(String name) {
        return new Factory(name, "Country-"+RANDOM.nextInt(500));
    }
}
