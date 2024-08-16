package me.cauadeveloper.sqlite.consulta.geral;

import me.cauadeveloper.sqlite.config_banco.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkTablesAreNull {

    public static int check_if_tableFunc_is_null() throws SQLException {

        String sql = """
                SELECT COUNT(*) as contador FROM funcionario
                """;
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            ResultSet resultSet =  stmt.executeQuery();
            return resultSet.getInt("contador"); // retorna zero

        }catch (SQLException e){
            System.out.println("Erro no check_if_tableFunc_is_null\n" + e.getMessage());
            // Preciso mandar uma mensagem para o usuário.
        }
        return 1;
    }
}
