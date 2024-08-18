package me.cauadeveloper.sqlite.config_banco;

import me.cauadeveloper.sqlite.tabelas.TabelaFunc;
import me.cauadeveloper.sqlite.tabelas.TabelaTarefa;
import me.cauadeveloper.sqlite.tabelas.TabelaTime;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Config {

    public static File databaseFile = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/sqlite/banco/devbot.db");

    public static void createFilesAndTable() throws IOException, SQLException {

        if(!databaseFile.exists()){
            databaseFile.createNewFile();
            TabelaFunc.create_table();
            TabelaTime.create_table();
            TabelaTarefa.create_table();
//            table_funcionario.insert_data_user_func();
//            table_time.insert_data_user_time();
//            table_tarefa.insert_data_user_tarefa();
        }

    }

}
