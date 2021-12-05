package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
        public static void main(String[] args) {
            DBconnect obj_DBconnect = new DBconnect();
            System.out.println(obj_DBconnect.get_connection());

        }

        public Connection get_connection() {
            Connection connection = null;

            try {
                Class.forName("org.postgresql.Driver");

                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgreSQL");
                //wyświetli czy połączono z bazą danych
                //System.out.println("Connected to the PostgreSQL server successfully.");
                //connection.close();

                if(connection != null) {
                    System.out.println("connection success");
                } else {
                    System.out.println("connection failed");
                }

            } catch (ClassNotFoundException e) {

                e.printStackTrace();
                System.out.append("no driver");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.append("wrong data");
            }
            return connection;
        }

}
