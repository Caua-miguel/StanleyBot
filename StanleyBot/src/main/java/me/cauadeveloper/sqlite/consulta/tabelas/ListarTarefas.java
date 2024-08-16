package me.cauadeveloper.sqlite.consulta.tabelas;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListarTarefas {

    public static ArrayList<String> selectListaTarefas() throws SQLException {

        String sql = """
                SELECT descricao from tarefa
                """;
        ArrayList<String> list = new ArrayList<>();

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                list.add(resultSet.getString("descricao"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}