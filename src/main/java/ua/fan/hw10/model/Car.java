package ua.fan.hw10.model;

public class Car implements Recovery{
    protected int series;
    protected int year;
    protected String color;
    protected int currentFuelLevel;
    protected final int MAX_FUEL = 100;

    public Car(int series, int year, String color, int currentFuelLevel) {
        this.series = series;
        this.year = year;
        this.color = color;
        if (currentFuelLevel < MAX_FUEL){
            this.currentFuelLevel = currentFuelLevel;
        } else {
            this.currentFuelLevel = MAX_FUEL;
        }
    }

    public void movement() {
        System.out.println("Let's start the trip!");
        int distance = 0;
        while (currentFuelLevel > 0){
            currentFuelLevel --;
            distance += 10;
        }
        System.out.println("The trip is over: no fuel left.");
        System.out.println("Traveled distance: " + distance);
    }

    public void printStatistics() {
        System.out.println(
                "Series: " + series +
                "\nYear: " + year +
                "\nColor: " + color +
                "\nFuel: " + currentFuelLevel);
    }

    @Override
    public void refuel() {
        currentFuelLevel = MAX_FUEL;
        System.out.println("Car is refueled! \nFuel: " + currentFuelLevel);
    }
}