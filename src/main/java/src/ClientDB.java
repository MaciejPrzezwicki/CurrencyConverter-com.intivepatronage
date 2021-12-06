package src;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientDB {

    public static void addToDB(String name, double endRate){
//Dodawanie bazy danych
        Connection connection = null;
        PreparedStatement statement = null;
        DBconnect obj_DBconnect = new DBconnect();
        connection = obj_DBconnect.get_connection();

//funkcja właściwa
        try {
            // String query = String.format("INSERT INTO table2(isoname, currencyrate) VALUES(%s, %f)", name, endRate);
            String query = "INSERT INTO table2(isoname,currencyrate) VALUES(?,?) ON CONFLICT (isoname) DO UPDATE SET currencyrate = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setDouble(2, endRate);
            statement.setDouble(3, endRate);
            statement.executeUpdate();
// możliwość sprawdzenia w programie czy kurs został dodany przez odkomentowanie następnej linijki
// System.out.println("value added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}



