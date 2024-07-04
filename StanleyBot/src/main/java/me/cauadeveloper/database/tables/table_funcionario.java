package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.database.dataconfig.readConfig.dataUser;
import static me.cauadeveloper.utils.files.inputUser.readFileUserCollumnA;

public class table_funcionario {

    public static void insert_data_user() throws SQLException{
        String sql = """
                INSERT into nome(nome) values (?)
                )
                """;
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            String[] data;
            data = dataUser();

            for (int i = 1; i <= data.length-1; i++){
                stmt.setString(1, data[i]);
                stmt.execute();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static void create_table() throws SQLException {

        String sql = """
                CREATE TABLE funcionario (
                    id integer PRIMARY KEY AUTOINCREMENT NOT NULL,
                    nome varchar(255) NOT NULL,
                    idTime,
                    FOREIGN KEY (idTime) REFERENCES time (id)
                )
                """;
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
