package me.cauadeveloper.sqlite.consulta.tabelas;

import me.cauadeveloper.sqlite.config_banco.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NamesFunc {

    public static ArrayList<String> selectNomeFunc() throws SQLException {

        String sql = """
                SELECT nome from funcionario
                """;
        ArrayList<String> list = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                list.add(resultSet.getString("nome"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static String selectUmNomeFunc(int idFunc) throws SQLException {

        String sql = """
                SELECT nome from funcionario WHERE id = ?
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){


            stmt.setInt(1, idFunc);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
               return resultSet.getString("nome");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public static ArrayList<Integer> selectIdFunc() throws SQLException {

        String sql = """
                SELECT id from funcionario
                """;
        ArrayList<Integer> list = new ArrayList<>();


        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                list.add(resultSet.getInt("id"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
