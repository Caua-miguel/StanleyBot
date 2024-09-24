package me.cauadeveloper.sqlite.consulta.tabelas;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaTarefas {

    public static ArrayList<String> selectListaTarefas() throws SQLException {

        String sql = """
                SELECT
                    CASE
                        WHEN instr(descricao, ' ') > 0 THEN substr(descricao, 1, instr(descricao, ' ') - 1) || '...'
                        ELSE descricao
                    END AS primeira_palavra
                FROM
                    tarefa;
                """;
        ArrayList<String> list = new ArrayList<>();

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                list.add(resultSet.getString("primeira_palavra"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static String selectUmaDescTarefas(int idTarefa) throws SQLException {

        String sql = """
                SELECT
                    CASE
                        WHEN instr(descricao, ' ') > 0 THEN substr(descricao, 1, instr(descricao, ' ') - 1) || '...'
                        ELSE descricao
                    END AS primeira_palavra
                FROM
                    tarefa
                WHERE id = ?;
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setInt(1, idTarefa);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                return resultSet.getString("primeira_palavra");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public static ArrayList<String> selectIdTarefa() throws SQLException {

        String sql = """
                SELECT id FROM tarefa;
                """;

        ArrayList<String> listaIdTarefa = new ArrayList<>();

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){


            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                listaIdTarefa.add(resultSet.getString("id"));
            }

            return listaIdTarefa;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaIdTarefa;
    }


}
