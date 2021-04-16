package models;

public class SmartWatch extends Device
{
    private boolean heartRateSens;
    private int diameterMm;
    private String finish; //Material made out of.

    /**
     * This is the constructor for the SmartWatch object.
     */

    public SmartWatch(String manufacturer, String model, double price, int serialNum, boolean heartRateSens, int diameterMm, String finish)
    {
        super(manufacturer, model, price, serialNum);
        setHeartRateSens(heartRateSens);
        setDiameterMm(diameterMm);
        setFinish(finish);
    }

    /**
     * This is the get method that returns a boolean, saying if the watch has a heart rate sensor.
     */

    public boolean getHeartRateSens()
    {
        return heartRateSens;
    }

    /**
     * This is the set method for the heart rate sensor that takes in boolean.
     */

    public void setHeartRateSens(boolean heartRateSens)
    {
        this.heartRateSens = heartRateSens;
    }

    /**
     * This is the get method for the diameter of the watch in millimeters.
     */

    public int getDiameterMm()
    {
        return diameterMm;
    }

    /**
     * This is the set method for the diameter of the watch. It only takes in values between 0 and 100 mm.
     */

    public void setDiameterMm(int diameterMm)
    {
        if (diameterMm >= 0 && diameterMm <= 100)
            this.diameterMm = diameterMm;
        else
            throw new IllegalArgumentException("The watches' screen diameter must be between 0 and 100 millimeters.");
    }

    /**
     * This is the get method that returns the name of the watch's finish.
     */

    public String getFinish()
    {
        return finish;
    }

    /**
     * This is the set method for the finish that takes in strings between 2 and 25 characters long.
     */

    public void setFinish(String finish)
    {
        if (finish.length() >= 2 && finish.length() <= 25)
        {
            finish = finish.substring(0, 1) + finish.substring(1);
            this.finish = finish;
        }
        else
            throw new IllegalArgumentException("The finish name must be between 2 and 50 characters long.");
    }
}
