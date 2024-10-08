package me.cauadeveloper.sqlite.consulta;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.geral.ContadorLinhasTabela.maxLinesTableTime;

public class verificarTabelaVaziaTest {

    @DisplayName("Checando se todos os valores da tabela funcionario estão vazios")
    @Test
    public void check_if_tableFunc_is_null() throws SQLException {

        String sql = """
                SELECT COUNT(*) as contador FROM time;
                """;
        try (PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)) {

            ResultSet resultSet = stmt.executeQuery();
            int saida = resultSet.getInt("contador");
            System.out.println(saida);
            int esperado = 0;
            Assertions.assertEquals(esperado, saida);

        } catch (SQLException e) {
            System.out.println("Erro no check_if_tableFunc_is_null\n" + e.getMessage());
        }
    }
        @DisplayName("Contador da tabela time")
        @Test
        public void simples_contador_tabela_time() throws SQLException {

            System.out.println(maxLinesTableTime());

        }
}
