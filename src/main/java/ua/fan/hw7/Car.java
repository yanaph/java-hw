package ua.fan.hw7;

public class Car {
    private String manufacturer;
    private String engine;
    private String color;
    private int petrol;


    public Car(String manufacturer, String engine, String color, int petrol) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.petrol = petrol;
    }

    public Car(String manufacturer, String engine, String color) {
        this(manufacturer,engine,color, 100);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPetrol() {
        return petrol;
    }

    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", engine='" + engine + '\'' +
                ", color='" + color + '\'' +
                ", petrol=" + petrol +
                '}';
    }

    public void startEngine(String name) {
        System.out.println(name + " запустил двигатель");
    }

    public boolean isEnoughPetrolLevel() {
        return this.petrol >= 50;
    }
}
