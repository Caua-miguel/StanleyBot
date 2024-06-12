package me.cauadeveloper.database.dataconfig;

import me.cauadeveloper.database.tables.*;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.sql.SQLException;

public class Config {

    public static File databaseFile = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/database/data/devbot");

    public static void createFilesAndTable() throws IOException, SQLException {

        if(Files.notExists(databaseFile.toPath())){

            Files.createFile(databaseFile.toPath());
            Table_Funcionarios_Omega.createTableFuncionarios();
            Table_Funcionario_Grupo.createTableFuncionariosGrupo();
            Table_Time.createTableTime();
            Table_Tarefa.createTableTarefa();
            Table_Time_Tarefa.createTableTimeTarefa();

        }

    }

}
