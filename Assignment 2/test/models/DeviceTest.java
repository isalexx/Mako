package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {

    Device device;

    @BeforeEach
    void setUp()
    {
        device = new Device("Apple", "Iphone 7", 699.99, 1234567);
    }

    /**
     * This tests the set method assuming valid values were entered.
     */

    @Test
    void setManufacturer()
    {
        device.setManufacturer("Samsung");
        assertEquals("Samsung", device.getManufacturer());
    }

    /**
     * This tests the set manufacturer method assuming the string entered was too short. should throw an exception.
     */

    @Test
    void setManufacturerInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                device.setManufacturer("S"));
    }

    /**
     * This tests the set manufacturer method assuming the string was too long. should throw an exception.
     */

    @Test
    void setManufacturerInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                device.setManufacturer("----|----|----|----|----|----|-"));
    }

    /**
     * This tests the set model method assuming correct input was provided.
     */

    @Test
    void setModel()
    {
        device.setModel("Galaxy S7");
        assertEquals("Galaxy S7", device.getModel());
    }

    /**
     * This tests the set model method assuming the string provided was too short. Should throw an exception.
     */

    @Test
    void setModelInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                device.setModel("G"));
    }

    /**
     * This tests the set model method, assuming the string provided was too long. should throw an exception.
     */

    @Test
    void setModelInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                device.setModel("----|----|----|----|----|----|----|----|----|----|-"));
    }

    /**
     * This tests the set price method assuming the input was valid.
     */

    @Test
    void setPrice()
    {
        device.setPrice(889.99);
        assertEquals(889.99, device.getPrice());
    }

    /**
     * This tests the set price method assuming the price entered was negative. should throw an exception.
     */

    @Test
    void setPriceInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                device.setPrice(-1));
    }

    /**
     * This tests the set price method assuming the value provided was too high. Should throw an exception.
     */

    @Test
    void setPriceInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                device.setPrice(123456));
    }

    /**
     * This tests the set serial number method, assuming it was valid.
     */

    @Test
    void setSerialNum()
    {
        device.setSerialNum(1888999);
        assertEquals(1888999, device.getSerialNum());
    }

    /**
     * This tests the set serial number method, assuming the serial number was too high. should throw an exception.
     */

    @Test
    void setSerialNumInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                device.setSerialNum(19919919));
    }

    /**
     * This tests the set serial number method, assuming the value entered was too low. should throw an exception.
     */

    @Test
    void setSerialNumInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                device.setSerialNum(123));
    }
}