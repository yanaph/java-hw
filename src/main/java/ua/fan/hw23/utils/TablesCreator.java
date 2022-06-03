package ua.fan.hw23.utils;

import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class TablesCreator {
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/DeviceManufacturing";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "root";

    @SneakyThrows
    public static void createTable(){
        String deviceTable = "CREATE TABLE devices (" +
                "Device_id serial not Null," +
                "Type varchar(250) not Null," +
                "Model varchar(250) not Null," +
                "Price Integer not Null," +
                "Manufacture_date date NOT NULL, " +
                "Description text not Null," +
                "In_stock boolean not Null," +
                "Factory_id varchar(250) not Null," +
                "PRIMARY KEY (Device_id)," +
                "FOREIGN KEY (Factory_id) REFERENCES factories(Factory_id))";

        String factoryTable = "CREATE TABLE factories (" +
                "Factory_id varchar(250) not Null," +
                "Name varchar(250) not Null," +
                "Country varchar(250) not Null," +
                "PRIMARY KEY (Factory_id))";

        Statement statement = getStatement();
        statement.executeUpdate(factoryTable);
        statement.executeUpdate(deviceTable);
        System.out.println("Tables were successfully created in database!");

    }

    @SneakyThrows
    private static Statement getStatement() {
        Connection connection = getMyConnection();
        return connection.createStatement();
    }

    @SneakyThrows
    private static Connection getMyConnection() {
        return DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
    }

    @SneakyThrows
    public static PreparedStatement getPreparedStatement(String sql) {
        Connection connection = getMyConnection();
        return connection.prepareStatement(sql);
    }
}
