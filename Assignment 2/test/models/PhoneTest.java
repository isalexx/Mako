package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    Phone phone;

    @BeforeEach
    void setUp()
    {
        phone = new Phone("Apple", "Iphone 7", 699.99, 1234567, 7.4, 104, "Apple OS 3", 224, "Midnight Black");
    }

    @Test
    void setScreenSizeInch()
    {
        phone.setScreenSizeInch(8.9);
        assertEquals(8.9, phone.getScreenSizeInch());
    }

    @Test
    void setScreenSizeInchInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setScreenSizeInch(-1));
    }

    @Test
    void setScreenSizeInchInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setScreenSizeInch(101));
    }

    @Test
    void setCameraMp()
    {
        phone.setCameraMp(64);
        assertEquals(64, phone.getCameraMp());
    }

    @Test
    void setCameraMpInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setScreenSizeInch(-1));
    }

    @Test
    void setCameraMpInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setScreenSizeInch(1001));
    }


    @Test
    void setOperatingSystem()
    {
        phone.setOperatingSystem("Apple OS 3");
        assertEquals("Apple OS 3", phone.getOperatingSystem());
    }

    @Test
    void setOperatingSystemInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setOperatingSystem("a"));
    }

    @Test
    void setOperatingSystemInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setOperatingSystem("agfdgdfgdf sdfgdfsgsdfgfd dfsgsdgsdfgsdfg"));
    }

    @Test
    void setMemoryGb()
    {
        phone.setMemoryGb(512);
        assertEquals(512, phone.getMemoryGb());
    }

    @Test
    void setMemoryGbInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setMemoryGb(-1));
    }

    @Test
    void setMemoryGbInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setMemoryGb(10001));
    }

    @Test
    void setColour()
    {
        phone.setColour("Rose Gold");
        assertEquals("Rose Gold", phone.getColour());
    }

    @Test
    void setColourInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setColour("F"));
    }

    @Test
    void setColourInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                phone.setColour("fdsfdsf dsfsdfsdfdsf dsfsdfsdfsdfsdf fdsfdsfdsfsdf"));
    }
}