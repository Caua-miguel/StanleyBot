package me.cauadeveloper.sqlite.consulta;

import me.cauadeveloper.sqlite.config_banco.ConnectionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkTablesAreNullTest {

    @DisplayName("Checando se todos os valores da tabela funcionario estão vazios")
    @Test
    public void check_if_tableFunc_is_null() throws SQLException {

        String sql = """
                SELECT COUNT(*) as contador FROM time;
                """;
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            ResultSet resultSet =  stmt.executeQuery();
            int saida = resultSet.getInt("contador");
            System.out.println(saida);
            int esperado = 0;
            Assertions.assertEquals(esperado, saida);

        }catch (SQLException e){
            System.out.println("Erro no check_if_tableFunc_is_null\n" + e.getMessage());
        }



    }
}
