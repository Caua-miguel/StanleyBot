package me.cauadeveloper.sqlite.consulta.geral;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContadorLinhasTabela {

    //maxLines vai virar um contador para as linhas com um select

    public static int maxLinesTableTime() throws SQLException {

        String sql = """
                SELECT COUNT(*) as contador FROM time
                """;
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            ResultSet resultSet =  stmt.executeQuery();
            return resultSet.getInt("contador");

        }catch (SQLException e){
            System.out.println("Erro no check_if_tableFunc_is_null\n" + e.getMessage());
        }
        return 0;
    }

    public static int maxLinesTableTarefa() throws SQLException {

        String sql = """
                SELECT COUNT(*) as contador FROM tarefa
                """;
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            ResultSet resultSet =  stmt.executeQuery();
            return resultSet.getInt("contador");

        }catch (SQLException e){
            System.out.println("Erro no check_if_tableFunc_is_null\n" + e.getMessage());
        }
        return 0;
    }

}
