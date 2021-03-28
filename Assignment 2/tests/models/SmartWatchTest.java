package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartWatchTest {

    SmartWatch watch;

    @BeforeEach
    void setUp()
    {
        watch = new SmartWatch("Samsung", "Galaxy Watch Active2", 384.99, 1234567, true, 42, "Rose Gold");
    }

    @Test
    void setHeartRateSens()
    {
        watch.setHeartRateSens(false);
        assertFalse(watch.getHeartRateSens());
    }

    @Test
    void setDiameterMm()
    {
        watch.setDiameterMm(38);
        assertEquals(38, watch.getDiameterMm());
    }

    @Test
    void setDiameterMmInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                watch.setDiameterMm(101));
    }

    @Test
    void setDiameterMmInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                watch.setDiameterMm(-1));
    }

    @Test
    void setFinish()
    {
        watch.setFinish("Silver");
        assertEquals("Silver", watch.getFinish());
    }

    @Test
    void setFinishInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                watch.setFinish("B"));
    }

    @Test
    void setFinishInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                watch.setFinish("||||/||||/||||/||||/||||/||||/||||/||||/||||/||||/|"));
    }
}