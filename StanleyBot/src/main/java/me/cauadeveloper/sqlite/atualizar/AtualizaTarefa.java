package me.cauadeveloper.sqlite.atualizar;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizaTarefa {

    public static void updateTarefa(int idTarefa, String nomeTarefa) throws SQLException {

        String sql = """
                UPDATE tarefa set descricao = ? WHERE id = ?
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setString(1, nomeTarefa);
            stmt.setInt(2, idTarefa);
            stmt.executeUpdate();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no updateTime\n" + e.getMessage());
        }

    }

}
