package ua.fan.service;

import java.util.Scanner;

public class InputService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public int getNumberInput(){
        return SCANNER.nextInt();
    }

    public String getStringInput(){
        return SCANNER.next();
    }
}
