package models;

import java.awt.*;

public class Device
{
    private String manufacturer;
    private String model;
    private double price;
    private int serialNum;

    public Device(String manufacturer, String model, double price, int serialNum)
    {
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setSerialNum(serialNum);
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        //This will capitalize the user input.
        manufacturer = manufacturer.substring(0, 1) + manufacturer.substring(1);
        if (manufacturer.length() >= 2 && manufacturer.length() <= 30)
            this.manufacturer = manufacturer;
        else
            throw new IllegalArgumentException("The manufacturer's name must be at least 2 characters long, maximum of 30 characters.");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model)
    {
        model = model.substring(0, 1) + model.substring(1);
        if (model.length() >= 2 && model.length() <= 50)
            this.model = model;
        else
            throw new IllegalArgumentException("The model's name must be at least 2 characters long, maximum of 50 characters.");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0 && price <= 100000)
            this.price = price;
        else
            throw new IllegalArgumentException("The price range must be between $0 and $100,000.");

    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        if (serialNum >= 1000000 && serialNum <= 9999999)
            this.serialNum = serialNum;
        else
            throw new IllegalArgumentException("Serial number must be between 1,000,000 and 9,999,999");
    }
}
