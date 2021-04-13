package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {

    SmartPhone smartPhone;

    @BeforeEach
    void setUp()
    {
        smartPhone = new SmartPhone("Apple", "Iphone 7", 699.99, 1234567, 7.4, 104, "Apple OS 3", 224, "Midnight Black");
    }

    @Test
    void setScreenSizeInch()
    {
        smartPhone.setScreenSizeInch(8.9);
        assertEquals(8.9, smartPhone.getScreenSizeInch());
    }

    @Test
    void setScreenSizeInchInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setScreenSizeInch(-1));
    }

    @Test
    void setScreenSizeInchInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setScreenSizeInch(101));
    }

    @Test
    void setCameraMp()
    {
        smartPhone.setCameraMp(64);
        assertEquals(64, smartPhone.getCameraMp());
    }

    @Test
    void setCameraMpInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setScreenSizeInch(-1));
    }

    @Test
    void setCameraMpInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setScreenSizeInch(1001));
    }


    @Test
    void setOperatingSystem()
    {
        smartPhone.setOperatingSystem("Apple OS 3");
        assertEquals("Apple OS 3", smartPhone.getOperatingSystem());
    }

    @Test
    void setOperatingSystemInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setOperatingSystem("a"));
    }

    @Test
    void setOperatingSystemInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setOperatingSystem("agfdgdfgdf sdfgdfsgsdfgfd dfsgsdgsdfgsdfg"));
    }

    @Test
    void setMemoryGb()
    {
        smartPhone.setMemoryGb(512);
        assertEquals(512, smartPhone.getMemoryGb());
    }

    @Test
    void setMemoryGbInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setMemoryGb(-1));
    }

    @Test
    void setMemoryGbInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setMemoryGb(10001));
    }

    @Test
    void setColour()
    {
        smartPhone.setColour("Rose Gold");
        assertEquals("Rose Gold", smartPhone.getColour());
    }

    @Test
    void setColourInvalid1()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setColour("F"));
    }

    @Test
    void setColourInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()->
                smartPhone.setColour("fdsfdsf dsfsdfsdfdsf dsfsdfsdfsdfsdf fdsfdsfdsfsdf"));
    }
}