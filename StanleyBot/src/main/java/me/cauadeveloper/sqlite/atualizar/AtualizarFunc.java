package me.cauadeveloper.sqlite.atualizar;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarFunc {

    public static void updateFuncionario(int id, String nomeFunc) throws SQLException{

        String sql = """
                UPDATE funcionario set nome = ? WHERE id = ?
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

                stmt.setString(1, nomeFunc);
                stmt.setInt(2, id);
                stmt.executeUpdate();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }

    }

}
