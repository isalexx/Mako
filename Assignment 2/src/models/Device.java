package models;

import java.awt.*;

public class Device
{
    private String manufacturer;
    private String model;
    private double price;
    private int serialNum;

    /**
     * This is the constructor for the Device class.
     * @return
     */

    public Device(String manufacturer, String model, double price, int serialNum)
    {
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setSerialNum(serialNum);
    }

    /**
     * This is the get method for Manufacturer.
     *
     */

    public String getManufacturer()
    {
        return manufacturer;
    }

    /**
     * This is the set method for the manufacturer that only takes in strings length 2 to 30 characters. Also capitalizes the first letter.
     *
     */

    public void setManufacturer(String manufacturer)
    {
        //This will capitalize the user input.
        if (manufacturer.length() >= 2 && manufacturer.length() <= 30)
        {
            manufacturer = manufacturer.substring(0, 1) + manufacturer.substring(1);
            this.manufacturer = manufacturer;
        }
        else
            throw new IllegalArgumentException("The manufacturer's name must be at least 2 characters long, maximum of 30 characters.");
    }

    /**
     * This is the get method for Model.
     *
     */

    public String getModel() {
        return model;
    }

    /**
     * This is the set method for Model, that takes strings that are 2 to 30 characters in length. Also capitalizes the first letter.
     *
     */

    public void setModel(String model)
    {

        if (model.length() >= 2 && model.length() <= 30)
        {
            model = model.substring(0, 1) + model.substring(1);
            this.model = model;
        }
        else
            throw new IllegalArgumentException("The model's name must be at least 2 characters long, maximum of 50 characters.");
    }

    /**
     * This is the get method for Price.
     *
     */

    public double getPrice()
    {
        return price;
    }

    /**
     * This is the set method for price, where the price has to be between $0 and $100,000.
     *
     */

    public void setPrice(double price)
    {
        if (price >= 0 && price <= 100000)
            this.price = price;
        else
            throw new IllegalArgumentException("The price range must be between $0 and $100,000.");

    }

    /**
     * This is the get method for Seriam Number.
     *
     */

    public int getSerialNum()
    {
        return serialNum;
    }

    /**
     * This is the set method for the serial number, which has to be between 1,000,000 and 9,999,999.
     *
     */

    public void setSerialNum(int serialNum)
    {
        if (serialNum >= 1000000 && serialNum <= 9999999)
            this.serialNum = serialNum;
        else
            throw new IllegalArgumentException("Serial number must be between 1,000,000 and 9,999,999");
    }
}
