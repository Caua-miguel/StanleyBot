package me.cauadeveloper.sqlite.inserir;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NovoTime {

    public static void insertNovoTime(String nomeTime) throws SQLException {
        String sql = """
                INSERT INTO time (nome, status) values (?, ?)
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){


            stmt.setString(1, nomeTime);
            stmt.setString(2, "true");

            stmt.execute();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }
    }

}
