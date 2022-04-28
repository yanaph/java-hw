package ua.fan.hw11;

import ua.fan.hw11.model.BasicPhone;
import ua.fan.hw11.model.FeaturePhone;
import ua.fan.hw11.model.Phone;
import ua.fan.hw11.model.Smartphone;

public class Main {
    public static void main(String[] args) {

        Phone standardBasicPhone = new BasicPhone();
        Phone basicPhone = new BasicPhone(80, false, "White", true);
        System.out.println("------------> " + basicPhone.getClass().getSimpleName().toUpperCase());
        System.out.println("---> Service:");
        basicPhone.phoneTroubleshooting();

        if (basicPhone instanceof BasicPhone basicPhone1) {
            System.out.println("---> Play Snake: ");
            basicPhone1.playSnake();
        }

        System.out.print("---> Comparing: ");
        basicPhone.compare(standardBasicPhone);


        Phone standardFeaturePhone = new FeaturePhone();
        Phone featurePhone = new FeaturePhone(100, true, "Pink", true);
        System.out.println("\n------------> " + featurePhone.getClass().getSimpleName().toUpperCase());
        System.out.println("---> Service:");
        featurePhone.phoneTroubleshooting();

        if (featurePhone instanceof FeaturePhone featurePhone1) {
            System.out.println("---> Connect to equals: ");
            featurePhone1.connectToTheInternet();
        }

        System.out.print("---> Comparing: ");
        featurePhone.compare(standardFeaturePhone);


        Phone standardSmartphone = new Smartphone();
        Phone smartphone = new Smartphone(70, true, "White", true);
        System.out.println("\n------------> " + smartphone.getClass().getSimpleName().toUpperCase());
        System.out.println("---> Service:");
        smartphone.phoneTroubleshooting();

        if (smartphone instanceof Smartphone smartphone1) {
            System.out.println("---> Unlock smartphone: ");
            smartphone1.unlockPhoneUsingFaceID();
        }

        System.out.print("---> Comparing: ");
        smartphone.compare(standardSmartphone);
    }
}