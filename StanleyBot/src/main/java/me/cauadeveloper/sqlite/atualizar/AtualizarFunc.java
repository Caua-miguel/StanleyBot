package me.cauadeveloper.sqlite.atualizar;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarFunc {

    public static void updateFuncionario(String novoId, String nome, String id) throws SQLException{

        String sql = """
                UPDATE funcionario set id = ?, nome = ? WHERE id = ?
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

                stmt.setString(1, novoId);
                stmt.setString(2, nome);
                stmt.setString(3, id);
                stmt.executeUpdate();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }

    }

}
