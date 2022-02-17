package ua.fan.hw7;

public class Main {
    public static void main(String[] args) {
        Car sabre = new Car("McLaren", "Turbocharged", "Orange", 87);
        Car shelby = new Car("Mustang", "Supercharged ", "Grey", 30);
        Car camaro = new Car("Chevrolet", "Turbocharged ", "Yellow");

        System.out.println("--> Sabre:\n" + sabre);
        System.out.println("--> Shelby:\n" + shelby);
        System.out.println("--> Camaro:\n" + camaro);

        System.out.println("\n-->Starting engines for a trip! ");
        startTravelling(sabre, "McLaren Sabre");
        startTravelling(shelby, "Mustang Shelby");
        startTravelling(camaro, "Chevrolet Camaro");

    }

    private static void startTravelling(Car obj, String name){
        if (obj.isEnoughPetrolLevel()){
            obj.startEngine("McLaren Sabre");
        } else {
            System.out.println(name + "'s petrol level is too low to start a trip!");
        }
    }
}
