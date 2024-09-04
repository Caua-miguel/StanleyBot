package me.cauadeveloper.sqlite.consulta.tabelas;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListarFunc {

    public static ArrayList<String> selectNomeFunc() throws SQLException {

        String sql = """
                SELECT nome from funcionario
                """;
        ArrayList<String> list = new ArrayList<>();

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                list.add(resultSet.getString("nome"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static String selectUmNomeFunc(String idFunc) throws SQLException {

        String sql = """
                SELECT nome from funcionario WHERE id = ?
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){


            stmt.setString(1, idFunc);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
               return resultSet.getString("nome");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public static ArrayList<String> selectIdFunc() throws SQLException {

        String sql = """
                SELECT id from funcionario
                """;
        ArrayList<String> list = new ArrayList<>();


        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                list.add(resultSet.getString("id"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
