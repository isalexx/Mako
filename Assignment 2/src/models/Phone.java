package models;

import java.awt.*;

public class Phone extends Device
{
    private float screenSizeInch;
    private int cameraMp;
    private String operatingSystem;
    private int memoryGb;
    private String colour;



    public Phone(String manufacturer, String model, double price, int serialNum, float screenSizeInch, int cameraMp, String operatingSystem, int memoryGb, String colour)
    {
        super(manufacturer, model, price, serialNum);
        setScreenSizeInch(screenSizeInch);
        setCameraMp(cameraMp);
        setOperatingSystem(operatingSystem);
        setMemoryGb(memoryGb);
        setColour(colour);
    }

    public float getScreenSizeInch()
    {
        return screenSizeInch;
    }

    public void setScreenSizeInch(float screenSizeInch)
    {
        if (screenSizeInch > 0 && screenSizeInch <= 100)
            this.screenSizeInch = screenSizeInch;
        else
            throw new IllegalArgumentException("The screen must be between 1 and 100 inches in size.");
    }

    public int getCameraMp()
    {
        return cameraMp;
    }

    public void setCameraMp(int cameraMp)
    {
        if (cameraMp >= 0 && cameraMp <= 1000)
            this.cameraMp = cameraMp;
        else
            throw new IllegalArgumentException("The camera megapixel value must be between 0 and 1,000 megapixels.");
    }

    public String getOperatingSystem()
    {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem)
    {
        operatingSystem = operatingSystem.substring(0, 1) + operatingSystem.substring(1);
        if (operatingSystem.length() >= 2 && operatingSystem.length() <= 50)
            this.operatingSystem = operatingSystem;
        else
            throw new IllegalArgumentException("The operating system's name must be between 2 and 50 characters.");
    }

    public int getMemoryGb()
    {
        return memoryGb;
    }

    public void setMemoryGb(int memoryGb)
    {
        if (memoryGb >= 0 && memoryGb <= 10000)
            this.memoryGb = memoryGb;
        else
            throw new IllegalArgumentException("The phone's memory must be between 0 and 10,000 gigabytes.");
    }

    public String getColour()
    {
        return colour;
    }

    public void setColour(String colour)
    {
        colour = colour.substring(0, 1) + colour.substring(1);
        if (colour.length() >= 2 && colour.length() <= 50)
            this.colour = colour;
        else
            throw new IllegalArgumentException("The colour name's length must be between 2 and 50 characters.");
    }
}
