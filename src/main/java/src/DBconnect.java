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

//Możliwość wyświetlenia w programie czy nastąpiło poprawne połączenie z bazą po odkomentowaniu poniższego if-else'a
//                if(connection != null) {
//                    System.out.println("połączono");
//                } else {
//                    System.out.println("połączenie nieudane");
//                }

            } catch (ClassNotFoundException e) {

                e.printStackTrace();
                System.out.append("brak sterownika");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.append("złe dane");
            }
            return connection;
        }

}
