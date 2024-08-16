package me.cauadeveloper.sqlite.config_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    public static Connection getConn() throws SQLException {

        String url = "jdbc:sqlite:/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/database/data/devbot.db";

        try {
            return DriverManager.getConnection(url);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

}
