package me.cauadeveloper.database.dataconfig;

import me.cauadeveloper.database.tables.table_funcionario;
import me.cauadeveloper.database.tables.table_tarefa;
import me.cauadeveloper.database.tables.table_time;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Config {

    public static File databaseFile = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/database/data/devbot.db");

    public static void createFilesAndTable() throws IOException, SQLException {

        if(!databaseFile.exists()){
            databaseFile.createNewFile();
            table_funcionario.create_table();
            table_time.create_table();
            table_tarefa.create_table();
//            table_funcionario.insert_data_user_func();
//            table_time.insert_data_user_time();
//            table_tarefa.insert_data_user_tarefa();
        }

    }

}
