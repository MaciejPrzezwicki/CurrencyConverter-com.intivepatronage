package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
        public static void main(String[] args) throws SQLException {

            try {
                Class.forName("org.postgresql.Driver");

                Connection connection = null;


                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres","postgres", "postgreSQL");
//wyświetli czy połączono z bazą danych
                System.out.println("Connected to the PostgreSQL server successfully.");
                connection.close();

            } catch (ClassNotFoundException e) {

                e.printStackTrace();
                System.out.append("no driver");
            }
            catch (SQLException e )
            {
                e.printStackTrace();
                System.out.append("wrong data");
            }
        }


}
