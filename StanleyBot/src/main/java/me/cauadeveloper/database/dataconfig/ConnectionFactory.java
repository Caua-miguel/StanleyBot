package me.cauadeveloper.database.dataconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConn() throws SQLException {

        String url = "jdbc:sqlite:C:\\Users\\caua\\Documents\\Dev\\BackEnd\\BotDiscord\\CoffeBot\\StanleyBot\\src\\main\\java\\me\\cauadeveloper\\database\\devbot.db";

        try {
            return DriverManager.getConnection(url);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

}
