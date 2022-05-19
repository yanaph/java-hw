package ua.fan.hw18;

import ua.fan.hw18.model.Box;
import ua.fan.hw18.model.Cargo;
import ua.fan.hw18.model.MaxLiftingCapacity;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        Path xmlFile = Path.of("src/main/java/ua/fan/hw18/resources/hw.xml");
        Path jsonFile = Path.of("src/main/java/ua/fan/hw18/resources/hw.json");

        System.out.print("XML ");
        Box xmlBox = getBoxFromXml(xmlFile);
        System.out.println(xmlBox);

        System.out.print("\nJSON ");
        Box jsonBox = getBoxFromJson(jsonFile);
        System.out.println(jsonBox);
    }

    private static Box getBoxFromJson(Path jsonFile) throws IOException {
        Box box = new Box();
        String content = Files.readString(jsonFile, StandardCharsets.US_ASCII);

        box.setFrom(searchValue(content, "\"from\":.\"(.*?)\""));
        box.setMaterial(searchValue(content, "\"material\":.\"(.*?)\""));
        box.setColor(searchValue(content, "\"color\":.\"(.*?)\""));

        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
        maxLiftingCapacity.setUnit(searchValue(content, "\"unit\":.\"(.*?)\""));
        maxLiftingCapacity.setValue(Integer.parseInt(searchValue(content, "\"value\":.(\\d*)")));
        box.setMaxLiftingCapacity(maxLiftingCapacity);

        Cargo cargo = new Cargo();
        cargo.setName(searchValue(content, "\"name\":.\"(.*)\""));
        cargo.setClassOfCargo(searchValue(content, "\"class\":.\"(.*)\""));
        box.setCargo(cargo);

        LocalDateTime date = LocalDateTime.parse(searchValue(content, "\"delivery-date\":.\"(.*)\""));
        box.setDeliveryDate(date);
        return box;
    }

    private static Box getBoxFromXml(Path xmlFile) throws IOException {
        Box box = new Box();
        String content = Files.readString(xmlFile, StandardCharsets.US_ASCII);

        box.setFrom(searchValue(content, ".*from=\"(.*?)\""));
        box.setMaterial(searchValue(content, ".*material=\"(.*?)\""));
        box.setColor(searchValue(content, "<color>(.*)<.color>"));

        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
        maxLiftingCapacity.setUnit(searchValue(content, ".*unit=\"(.*?)\""));
        maxLiftingCapacity.setValue(Integer.parseInt(searchValue(content, "<max-lifting-capacity.*>(.*?)<.max-lifting-capacity>")));
        box.setMaxLiftingCapacity(maxLiftingCapacity);

        Cargo cargo = new Cargo();
        cargo.setName(searchValue(content, "<name>(.*)<.name>"));
        cargo.setClassOfCargo(searchValue(content, "<class>(.*)<.class>"));
        box.setCargo(cargo);

        LocalDateTime date = LocalDateTime.parse(searchValue(content, "<delivery-date>(.*)<.delivery-date>"));
        box.setDeliveryDate(date);
        return box;
    }

    private static String searchValue(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        String result = "";
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }


}
