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

    /**
     * This tests the set heart rate sensor, assuming the input was correct.
     */

    @Test
    void setHeartRateSens()
    {
        watch.setHeartRateSens(false);
        assertFalse(watch.getHeartRateSens());
    }

    /**
     * This tests the set diameter method, assuming the input was correct.
     */

    @Test
    void setDiameterMm()
    {
        watch.setDiameterMm(38);
        assertEquals(38, watch.getDiameterMm());
    }

    /**
     * This tests the set diameter method assuming the value provided is invalid. should throw an exception.
     */

    @Test
    void setDiameterMmInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                watch.setDiameterMm(101));
    }

    /**
     * This tests the diameter set method assuming the value entered is invalid. should throw an exception.
     */

    @Test
    void setDiameterMmInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                watch.setDiameterMm(-1));
    }

    /**
     * This tests the set finish method, assuming the value entered was valid.
     */

    @Test
    void setFinish()
    {
        watch.setFinish("Silver");
        assertEquals("Silver", watch.getFinish());
    }

    /**
     * This tests the set finish method, assuming the value entered is too short. should throw an exception.
     */

    @Test
    void setFinishInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                watch.setFinish("B"));
    }

    /**
     * This tests the set finish method, assuming the value entered was too long. should throw an exception.
     */

    @Test
    void setFinishInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                watch.setFinish("----|----|----|----|----|----|----|----|----|----|-"));
    }
}