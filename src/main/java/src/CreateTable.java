package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateTable {

    public static void execute() {
        //Dodawanie bazy danych
        Connection connection = null;
        PreparedStatement statement = null;
        DBconnect obj_DBconnect = new DBconnect();
        connection = obj_DBconnect.get_connection();

//funkcja właściwa
        try {
            // String query = String.format("INSERT INTO table2(isoname, currencyrate) VALUES(%s, %f)", name, endRate);
            String sql = "CREATE TABLE IF NOT EXISTS table2 (isoname VARCHAR(255) not NULL, currencyrate FLOAT,PRIMARY KEY (isoname))";

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


