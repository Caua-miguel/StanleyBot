package me.cauadeveloper.database.query.collumn_names;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NamesTeam {

    public static ArrayList<String> selectAllNomeTime() throws SQLException {

        String sql = """
                SELECT nome from time
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

    public static int selectNomeTime(String nomeTime) throws SQLException {

        String sql = """
                SELECT id FROM time WHERE nome = ?
                """;
        
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

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

}
