package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static me.cauadeveloper.database.dataconfig.readConfig.dataUserCollumnI;

public class table_tarefa {

    public static void insert_data_user_tarefa() throws SQLException{

        String sql = """
                INSERT INTO tarefa(descricao) values (?)
                """;
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            String[] data;
            data = dataUserCollumnI();

            for (int i = 1; i < data.length-1; i++){
                stmt.setString(1, data[i]);
                stmt.execute();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_data_user_tarefa\n" + e.getMessage());
        }
    }


    public static void create_table() throws SQLException {

        String sql = """
                CREATE TABLE tarefa(
                    id integer PRIMARY KEY AUTOINCREMENT NOT NULL,
                    descricao varchar NOT NULL
                )
                """;
        try (PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
