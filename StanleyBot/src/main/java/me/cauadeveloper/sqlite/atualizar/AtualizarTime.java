package me.cauadeveloper.sqlite.atualizar;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarTime {

    public static void updateTime(int idTime, String nomeTime) throws SQLException {

        String sql = """
                UPDATE time set nome = ? WHERE id = ?
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setString(1, nomeTime);
            stmt.setInt(2, idTime);
            stmt.executeUpdate();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no updateTime\n" + e.getMessage());
        }

    }


}
