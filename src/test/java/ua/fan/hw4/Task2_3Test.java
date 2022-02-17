package ua.fan.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2_3Test {
    private final int[] target = {1, 2, 3, 4};

    @Test
    void isPrimeNum_allFine(){
        Assertions.assertTrue(Task2_3.isPrimeNum(2));
        Assertions.assertFalse(Task2_3.isPrimeNum(6));
        Assertions.assertFalse(Task2_3.isPrimeNum(0));
        Assertions.assertFalse(Task2_3.isPrimeNum(1));
    }

    @Test
    void isCompositeNum_allFine(){
        Assertions.assertTrue(Task2_3.isCompositeNum(6));
        Assertions.assertFalse(Task2_3.isCompositeNum(2));
        Assertions.assertFalse(Task2_3.isCompositeNum(0));
        Assertions.assertFalse(Task2_3.isCompositeNum(1));
    }

    @Test
    void countPrimeNumbers_allFine(){
        Assertions.assertEquals(2, Task2_3.countPrimeNumbers(target));
    }

    @Test
    void countCompositeNumbers_allFine(){
        Assertions.assertEquals(1, Task2_3.countCompositeNumbers(target));
    }




}