package me.cauadeveloper.sqlite.consulta.geral;

import me.cauadeveloper.sqlite.config_banco.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class countLinesTable {

    //maxLines vai virar um contador para as linhas com um select

    public static int maxLinesTableTime() throws SQLException {

        String sql = """
                SELECT COUNT(*) as contador FROM time
                """;
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            ResultSet resultSet =  stmt.executeQuery();
            return resultSet.getInt("contador");

        }catch (SQLException e){
            System.out.println("Erro no check_if_tableFunc_is_null\n" + e.getMessage());
        }
        return 0;
    }

}
