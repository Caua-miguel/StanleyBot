package me.cauadeveloper.sqlite.inserir;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.geral.ContadorLinhasTabela.maxLinesTableTime;

public class NovoTime {

    public static void insertNovoTime(String nomeTime) throws SQLException {
        String sql = """
                INSERT INTO time (id, nome, status) values (?, ?, ?)
                """;

        int contadorLinhasTime = maxLinesTableTime();

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setInt(1, contadorLinhasTime + 1);
            stmt.setString(2, nomeTime);
            stmt.setString(3, "true");

            stmt.execute();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }
    }

}
