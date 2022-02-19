package ua.fan.hw10.model;

public class Truck extends Car implements Recovery{
    private double cargo;

    public Truck(int series, int year, String color) {
        super(series, year, color);
        fuel = 3000;
        this.cargo = 0;
    }

    public void cargoLoadingAndUnloading(double cargo) {
        if (cargo < 0) {
            if (this.cargo < -cargo || this.cargo == 0) {
                System.out.println("Truck is empty! Cargo can not be unloaded.");
            } else {
                this.cargo += cargo;
                System.out.println("Cargo was unloaded! " + this.cargo + " kg of cargo left.");
            }
        } else {
            this.cargo += cargo;
            System.out.println("Cargo was loaded! There are " + this.cargo + " kg of cargo now.");
        }
    }

    @Override
    public void movement() {
        System.out.println("-> Let's start the trip!");
        int distance = 0;
        while (fuel > 0) {
            fuel --;
            distance += 5;
            if (fuel % 750 == 0) {
                System.out.println("Distance travelled: " + distance + "km");
                System.out.println("Fuel left: " + fuel);
            }
        }
        System.out.println("-> The trip is over: no fuel left.");
    }

    @Override
    public void refuel() {
        fuel = 3000;
        System.out.println("Truck is refueled! \nFuel: " + fuel);
    }
}