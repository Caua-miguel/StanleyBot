package me.cauadeveloper.database.query.collumn_names;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class allNamesTeam {

    public static ArrayList<String> selectNomeTime() throws SQLException {

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

}
