package ua.fan.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    private final int[] target = {5, 5};

    @Test
    void mean_allFine(){
        Assertions.assertEquals(5, Task1.mean(target));
    }

    @Test
    void geometricMean_allFine(){
        Assertions.assertEquals(5, Task1.mean(target));
    }
}

