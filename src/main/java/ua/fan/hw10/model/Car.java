package ua.fan.hw10.model;

public class Car implements Recovery{
    protected int series;
    protected int year;
    protected String color;
    protected int fuel;

    public Car(int series, int year, String color) {
        this.series = series;
        this.year = year;
        this.color = color;
        fuel = 65;
    }

    public void movement() {
        System.out.println("-> Let's start the trip!");
        int distance = 0;
        while (fuel > 0) {
            fuel --;
            distance += 10;
            if (fuel % 20 == 0) {
                System.out.println("Distance travelled: " + distance + "km");
                System.out.println("Fuel left: " + fuel);
            }
        }
        System.out.println("-> The trip is over: no fuel left.");
    }

    public void statistics() {
        System.out.println(
                "Series: " + series +
                "\nYear: " + year +
                "\nColor: " + color +
                "\nFuel: " + fuel);
    }

    @Override
    public void refuel() {
        fuel = 65;
        System.out.println("Car is refueled! \nFuel: " + fuel);
    }
}