package dev.deyoung.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection createConnection(){

        String details = "jdbc:postgresql://34.121.107.181:5432/ihatebasketball?user=ldeyoung&password=lilsarahd"; //edit this to be your database!

        try {
            Connection conn = DriverManager.getConnection(details); //a factory method. pass in string details for any type of database
            //anywhere, and the DriverManager factory will give you back a connection implementation specifically for postgres

            return conn;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }

    }

}
