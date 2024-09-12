package me.cauadeveloper.sqlite.remover;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoverTarefa {

    public static void removerTarefa(String idTarefa) throws SQLException {

        String sql = """
                DELETE FROM tarefa WHERE id = ?
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setString(1, idTarefa);
            stmt.execute();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }

    }

}
