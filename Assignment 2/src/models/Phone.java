package models;

import java.awt.*;

public class Phone extends Device
{
    private double screenSizeInch;
    private int cameraMp;
    private String operatingSystem;
    private int memoryGb;
    private String colour;

    /**
     * This is the constructor for Phone class, that extends the Device class.
     *
     */

    public Phone(String manufacturer, String model, double price, int serialNum, double screenSizeInch, int cameraMp, String operatingSystem, int memoryGb, String colour)
    {
        super(manufacturer, model, price, serialNum);
        setScreenSizeInch(screenSizeInch);
        setCameraMp(cameraMp);
        setOperatingSystem(operatingSystem);
        setMemoryGb(memoryGb);
        setColour(colour);
    }

    /**
     * This is the get method for the size of the screen in inches.
     *
     */

    public double getScreenSizeInch()
    {
        return screenSizeInch;
    }

    /**
     * This is the set method for the size of the screen in inches. It only takes in values between 1 and 100 inches.
     *
     */

    public void setScreenSizeInch(double screenSizeInch)
    {
        if (screenSizeInch > 0 && screenSizeInch <= 100)
            this.screenSizeInch = screenSizeInch;
        else
            throw new IllegalArgumentException("The screen must be between 1 and 100 inches in size.");
    }

    /**
     * This is the get method for Camera megapixels value..
     *
     */

    public int getCameraMp()
    {
        return cameraMp;
    }

    /**
     * This is the set method for Camera Megapixels value, that only takes in values between 0 and 1,000
     *
     */

    public void setCameraMp(int cameraMp)
    {
        if (cameraMp >= 0 && cameraMp <= 1000)
            this.cameraMp = cameraMp;
        else
            throw new IllegalArgumentException("The camera megapixel value must be between 0 and 1,000 megapixels.");
    }

    /**
     * This is the get method for the Operating System.
     *
     */

    public String getOperatingSystem()
    {
        return operatingSystem;
    }

    /**
     * This is the set method for the operating system. It only intakes strings between 2 to 25 characters long.
     *
     */

    public void setOperatingSystem(String operatingSystem)
    {

        if (operatingSystem.length() >= 2 && operatingSystem.length() <= 25)
        {
            operatingSystem = operatingSystem.substring(0, 1) + operatingSystem.substring(1);
            this.operatingSystem = operatingSystem;
        }
        else
            throw new IllegalArgumentException("The operating system's name must be between 2 and 50 characters.");
    }

    /**
     * This is the get method for the amount of memory in a phone.
     *
     */

    public int getMemoryGb()
    {
        return memoryGb;
    }

    /**
     * This is the set method for the amount of memory in a phone. It only intakes values between 0 and 10,000.
     *
     */

    public void setMemoryGb(int memoryGb)
    {
        if (memoryGb >= 0 && memoryGb <= 10000)
            this.memoryGb = memoryGb;
        else
            throw new IllegalArgumentException("The phone's memory must be between 0 and 10,000 gigabytes.");
    }

    /**
     * This is the get method for the phone's colour.
     *
     */

    public String getColour()
    {
        return colour;
    }

    /**
     * This is the get method for the phone's colour, which only intakes strings between 2 and 25 charactes long.
     *
     */

    public void setColour(String colour)
    {

        if (colour.length() >= 2 && colour.length() <= 25)
        {
            colour = colour.substring(0, 1) + colour.substring(1);
            this.colour = colour;
        }
        else
            throw new IllegalArgumentException("The colour name's length must be between 2 and 50 characters.");
    }
}
