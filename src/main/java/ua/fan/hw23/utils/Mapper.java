package ua.fan.hw23.utils;

import lombok.SneakyThrows;
import ua.fan.hw23.model.Device;
import ua.fan.hw23.model.Factory;

import java.sql.ResultSet;

public class Mapper {
    @SneakyThrows
    public static Factory mapToObjectFactory(ResultSet resultSet) {
        final Factory factory = new Factory();
        factory.setId(resultSet.getString("factory_id"));
        factory.setName(resultSet.getString("name"));
        factory.setCountry(resultSet.getString("country"));
        return factory;
    }

    @SneakyThrows
    public static Device mapToObjectDevice(final ResultSet resultSet) {
        final Device device = new Device();
        device.setId(resultSet.getInt("device_id"));
        device.setType(resultSet.getString("type"));
        device.setModelName(resultSet.getString("model"));
        device.setPrice(resultSet.getInt("price"));
        device.setManufactureDate(resultSet.getDate("manufacture_date").toLocalDate());
        device.setDescription(resultSet.getString("description"));
        device.setInStock(resultSet.getBoolean("in_stock"));
        device.setFactoryId(resultSet.getString("factory_Id"));
        return device;
    }


}
