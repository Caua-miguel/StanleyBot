package me.cauadeveloper.sqlite.tabelas;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TabelaTarefa {

    public static void insert_data_user_tarefa(List<String> dataUser) throws SQLException{

        String sql = """
                INSERT INTO tarefa(descricao) values (?)
                """;
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            List<String> data;
            data = dataUser;

            for (int i = 0; i < data.size(); i++){
                stmt.setString(1, data.get(i));
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
        try (PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
