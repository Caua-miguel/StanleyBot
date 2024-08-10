package me.cauadeveloper.database.query.collumn_names;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class allNamesFunc {

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
