package ua.fan.hw9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class GetRandomNumberTest {
    private static Random RANDOM;
    private GetRandomNumber target;

    @BeforeEach
    void setUp(){
        RANDOM = Mockito.mock(Random.class);
        target = new GetRandomNumber();
    }

    @Test
    void get_allFineWhen0(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(0);
        Assertions.assertEquals(0, target.get(RANDOM));
    }

    @Test
    void get_allFineWhenLessThan10(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(5);
        Assertions.assertEquals(200, target.get(RANDOM));
    }

    @Test
    void get_allFineWhenLessThan20(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(15);
        Assertions.assertEquals(3, target.get(RANDOM));
    }

    @Test
    void get_allFineWhenLessThan50(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(45);
        Assertions.assertNull(target.get(RANDOM));
    }

    @Test
    void get_allFineWhenLessThan80(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(65);
        Assertions.assertEquals(-10, target.get(RANDOM));
    }

    @Test
    void get_allFineWhenMoreThan80LessThan100(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(90);
        Assertions.assertEquals(90, target.get(RANDOM));
    }

}
