package me.cauadeveloper.database.dataconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConn() throws SQLException {

        String url = "jdbc:sqlite:C:\\Dev\\BackEnd\\BotDiscord\\CoffeBot\\StanleyBot\\StanleyBot\\src\\main\\java\\me\\cauadeveloper\\database\\data\\devbot.db";

        try {
            return DriverManager.getConnection(url);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

}
