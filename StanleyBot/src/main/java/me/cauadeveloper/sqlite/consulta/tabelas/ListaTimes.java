package me.cauadeveloper.sqlite.consulta.tabelas;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaTimes {

    public static ArrayList<String> selectAllNomeTime() throws SQLException {

        String sql = """
                SELECT nome from time
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

    public static int selectIdTime(String nomeTime) throws SQLException {

        String sql = """
                SELECT id FROM time WHERE nome = ?
                """;
        
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setString(1, nomeTime);
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()){
                    return resultSet.getInt("id");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public static String selectNomeTime(int idTime) throws SQLException {

        String sql = """
                SELECT nome FROM time WHERE id = ?
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setInt(1, idTime);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                return resultSet.getString("nome");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

}
