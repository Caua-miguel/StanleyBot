package me.cauadeveloper.database.dataconfig;

import me.cauadeveloper.database.tables.refact.table_funcionario;
import me.cauadeveloper.database.tables.refact.table_tarefa;
import me.cauadeveloper.database.tables.refact.table_time;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.sql.SQLException;

public class Config {

    public static File databaseFile = new File("C:\\Dev\\BackEnd\\BotDiscord\\CoffeBot\\StanleyBot\\StanleyBot\\src\\main\\java\\me\\cauadeveloper\\database\\data\\devbot.db");

    public static void createFilesAndTable() throws IOException, SQLException {

        if(Files.notExists(databaseFile.toPath())){

            Files.createFile(databaseFile.toPath());
            table_funcionario.create_table();
            table_time.create_table();
            table_tarefa.create_table();
        }

    }

}
