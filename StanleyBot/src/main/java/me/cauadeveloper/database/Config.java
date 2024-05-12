package me.cauadeveloper.database;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.sql.SQLException;

public class Config {

    public static File databaseFile = new File("C:\\Users\\caua\\Documents\\Dev\\BackEnd\\BotDiscord\\StanleyBotLocal\\SQLite\\devbot.db");

    public static void createFilesAndTable() throws IOException, SQLException {

        if(Files.notExists(databaseFile.toPath())){

            Files.createFile(databaseFile.toPath());
            CRUD.createTable();

        }

    }

}
