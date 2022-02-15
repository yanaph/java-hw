package ua.fan.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    private final int[] target = {0, 1, 2, 3, 4, 5, 6};

    @Test
    void nullAllEvens_allFine() {
        for (int i = 0; i < target.length; i++) {
            if (target[i] % 2 == 0) {
                Assertions.assertEquals(0, Task4.nullAllEvens(target)[i]);
            }
        }
    }

}