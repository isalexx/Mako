package utilities;

import models.SmartPhone;
import models.SmartWatch;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility
{
    //These are the connection details.
    private static String user = "root";
    private static String password = "";
    private static String connectionString = "jdbc:mysql://localhost:3306/mako";

    public static ArrayList<SmartPhone> getPhonesFromDB() throws SQLException
    {

        ArrayList<SmartPhone> smartPhones = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(connectionString, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM smartphones;");
        )
        {
            while (resultSet.next())
            {
                SmartPhone newSmartPhone = new SmartPhone(resultSet.getString("manufacturer"),
                        resultSet.getString("model"),
                        resultSet.getInt("price"),
                        resultSet.getInt("serialNum"),
                        resultSet.getFloat("screenSizeInch"),
                        resultSet.getInt("cameraMp"),
                        resultSet.getString("operatingSystem"),
                        resultSet.getInt("memoryGb"),
                        resultSet.getString("colour")
                        );

                smartPhones.add(newSmartPhone);
            }
        }
        catch (SQLException error)
        {
            error.printStackTrace();
        }

        return smartPhones;
    }

    public static ArrayList<SmartWatch> getWatchesFromDB() throws SQLException
    {

        ArrayList<SmartWatch> watches = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(connectionString, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM smartwatches;");
        )
        {
            while (resultSet.next())
            {
                SmartWatch newWatch = new SmartWatch(resultSet.getString("manufacturer"),
                        resultSet.getString("model"),
                        resultSet.getInt("price"),
                        resultSet.getInt("serialNum"),
                        resultSet.getBoolean("heartRateSens"),
                        resultSet.getInt("diameterMm"),
                        resultSet.getString("finish")
                );

                watches.add(newWatch);
            }
        }
        catch (SQLException error)
        {
            error.printStackTrace();
        }

        return watches;
    }

    public static String insertPhoneIntoDB(SmartPhone newSmartPhone) throws SQLException {
        String message = "Failed!";

        try (
                Connection conn = DriverManager.getConnection(connectionString, user, password);
                PreparedStatement statement = conn.prepareStatement("INSERT INTO smartPhones (manufacturer, model, price, serialNum, screenSizeInch, cameraMp, operatingSystem, memoryGb, colour) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        )
        {


            //Bind the values to the datatype
            statement.setString(1, newSmartPhone.getManufacturer());
            statement.setString(2, newSmartPhone.getModel());
            statement.setDouble(3, newSmartPhone.getPrice());
            statement.setInt(4, newSmartPhone.getSerialNum());
            statement.setDouble(5, newSmartPhone.getScreenSizeInch());
            statement.setInt(6, newSmartPhone.getCameraMp());
            statement.setString(7, newSmartPhone.getOperatingSystem());
            statement.setInt(8, newSmartPhone.getMemoryGb());
            statement.setString(9, newSmartPhone.getColour());

            //Execute the insert statement.
            statement.executeUpdate();

            message = "Success!";
        }

        catch (Exception error)
        {
            error.printStackTrace();
        }
        finally
        {
            return message;
        }
    }

    public static String insertSmartWatchIntoDB(SmartWatch newSmartWatch) throws SQLException {
        String message = "Failed!";

        try (
                Connection conn = DriverManager.getConnection(connectionString, user, password);
                PreparedStatement statement = conn.prepareStatement("INSERT INTO smartWatches (manufacturer, model, price, serialNum, heartRateSens, diameterMm, finish) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?);");
        )
        {


            //Bind the values to the datatype
            statement.setString(1, newSmartWatch.getManufacturer());
            statement.setString(2, newSmartWatch.getModel());
            statement.setDouble(3, newSmartWatch.getPrice());
            statement.setInt(4, newSmartWatch.getSerialNum());
            statement.setBoolean(5, newSmartWatch.getHeartRateSens());
            statement.setInt(6, newSmartWatch.getDiameterMm());
            statement.setString(7, newSmartWatch.getFinish());

            //Execute the insert statement.
            statement.executeUpdate();

            message = "Success!";
        }

        catch (Exception error)
        {
            error.printStackTrace();
        }
        finally
        {
            return message;
        }
    }
}
