package me.cauadeveloper.sqlite.remover;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoverTime {

    public static void removerTime(String idTime) throws SQLException {

        String sql = """
                DELETE FROM time WHERE id = ?
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setString(1, idTime);
            stmt.execute();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }

    }

}
