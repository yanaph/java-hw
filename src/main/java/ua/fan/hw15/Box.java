package ua.fan.hw15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
public class Box {
    private double volume;
}

class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box obj1, Box obj2) {
        if (obj1.getVolume() == 0 && obj2.getVolume() == 0) {
            return 0;
        } else if (obj1.getVolume() == 0) {
            return -1;
        } else if (obj2.getVolume() == 0) {
            return 1;
        }
        return (int) (obj2.getVolume() - obj1.getVolume());
    }
}