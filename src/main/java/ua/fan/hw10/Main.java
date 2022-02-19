package ua.fan.hw10;

import ua.fan.hw10.model.Car;
import ua.fan.hw10.model.Passenger;
import ua.fan.hw10.model.PassengerCar;
import ua.fan.hw10.model.Truck;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------- CAR --------------");
        Car car = new Car(7, 2013, "Blue");
        System.out.println("-----> MOVEMENT METHOD:");
        car.movement();
        System.out.println("\n-----> STATISTICS METHOD:");
        car.statistics();
        System.out.println("\n-----> REFUEL METHOD:");
        car.refuel();

        System.out.println("\n-------------- PASSENGER CAR --------------");
        PassengerCar passengerCar = new PassengerCar(9, 2019, "Yellow");
        System.out.println("-----> PRINT ALL PASSENGERS METHOD:");
        passengerCar.printAllPassengers();
        System.out.println("\n-----> ADD PASSENGER METHOD:");
        Passenger passenger1 = new Passenger("Nazar Bezuhliy", 21);
        passengerCar.addPassenger(passenger1);
        passengerCar.addPassenger(passenger1);
        passengerCar.addPassenger(passenger1);
        passengerCar.addPassenger(passenger1);
        System.out.println("\n-----> PRINT ALL PASSENGERS METHOD:");
        passengerCar.printAllPassengers();
        System.out.println("\n-----> MOVEMENT METHOD:");
        passengerCar.movement();
        System.out.println("\n-----> REFUEL METHOD:");
        passengerCar.refuel();

        System.out.println("\n-------------- TRUCK --------------");
        Truck truck = new Truck(6, 2003, "Yellow");
        System.out.println("-----> CARGO LOADING/UNLOADING METHOD:");
        System.out.println("-> cargo = -5000 (kg)");
        truck.cargoLoadingAndUnloading(-5000);
        System.out.println("-> cargo = 5000 (kg)");
        truck.cargoLoadingAndUnloading(5000);
        System.out.println("-> cargo = -2000 (kg)");
        truck.cargoLoadingAndUnloading(-2000);
        System.out.println("\n-----> MOVEMENT METHOD:");
        truck.movement();
        System.out.println("\n-----> REFUEL METHOD:");
        truck.refuel();
    }

}
