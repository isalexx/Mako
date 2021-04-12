package utilities;

import models.Phone;
import models.SmartWatch;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DBUtility
{
    //These are the connection details.
    private static String user = "root";
    private static String password = "";
    private static String connectionString = "jdbc:mysql://localhost:3306/mako";

    public static ArrayList<Phone> getPhonesFromDB() throws SQLException
    {

        ArrayList<Phone> phones = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(connectionString, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM smartphones;");
        )
        {
            while (resultSet.next())
            {
                Phone newPhone = new Phone(resultSet.getString("manufacturer"),
                        resultSet.getString("model"),
                        resultSet.getInt("price"),
                        resultSet.getInt("serialNum"),
                        resultSet.getFloat("screenSizeInch"),
                        resultSet.getInt("cameraMp"),
                        resultSet.getString("operatingSystem"),
                        resultSet.getInt("memoryGb"),
                        resultSet.getString("colour")
                        );

                phones.add(newPhone);
            }
        }
        catch (SQLException error)
        {
            error.printStackTrace();
        }

        return phones;
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

    public static String insertPhoneIntoDB(Phone newPhone) throws SQLException {
        String message = "Failed!";

        try (
                Connection conn = DriverManager.getConnection(connectionString, user, password);
                PreparedStatement statement = conn.prepareStatement("INSERT INTO smartPhones (manufacturer, model, price, serialNum, screenSizeInch, cameraMp, operatingSystem, memoryGb, colour) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        )
        {


            //Bind the values to the datatype
            statement.setString(1, newPhone.getManufacturer());
            statement.setString(2, newPhone.getModel());
            statement.setDouble(3, newPhone.getPrice());
            statement.setInt(4, newPhone.getSerialNum());
            statement.setDouble(5, newPhone.getScreenSizeInch());
            statement.setInt(6, newPhone.getCameraMp());
            statement.setString(7, newPhone.getOperatingSystem());
            statement.setInt(8, newPhone.getMemoryGb());
            statement.setString(9, newPhone.getColour());

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
