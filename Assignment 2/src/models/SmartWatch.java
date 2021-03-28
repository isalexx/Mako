package models;

public class SmartWatch extends Device
{
    private boolean heartRateSens;
    private int diameterMm;
    private String finish; //Material made out of.

    public SmartWatch(String manufacturer, String model, double price, int serialNum, boolean heartRateSens, int diameterMm, String finish)
    {
        super(manufacturer, model, price, serialNum);
        setHeartRateSens(heartRateSens);
        setDiameterMm(diameterMm);
        setFinish(finish);
    }

    public boolean getHeartRateSens()
    {
        return heartRateSens;
    }

    public void setHeartRateSens(boolean heartRateSens)
    {
        this.heartRateSens = heartRateSens;
    }

    public int getDiameterMm()
    {
        return diameterMm;
    }

    public void setDiameterMm(int diameterMm)
    {
        if (diameterMm >= 0 && diameterMm <= 100)
            this.diameterMm = diameterMm;
        else
            throw new IllegalArgumentException("The watches' screen diameter must be between 0 and 100 millimeters.");
    }

    public String getFinish()
    {
        return finish;
    }

    public void setFinish(String finish)
    {
        if (finish.length() >= 2 && finish.length() <= 50)
            this.finish = finish;
        else
            throw new IllegalArgumentException("The finish name must be between 2 and 50 characters long.");
    }
}
