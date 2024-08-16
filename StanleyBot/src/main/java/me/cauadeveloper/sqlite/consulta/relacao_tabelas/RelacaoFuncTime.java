package me.cauadeveloper.sqlite.consulta.relacao_tabelas;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RelacaoFuncTime {

    public static void insert_idTime_in_func(String nomeTime, String nomeFunc) throws SQLException {
        String sql = """
                UPDATE funcionario set idTime = (SELECT id FROM time WHERE nome = ?) where nome = ?
                """;
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setString(1, nomeTime);
            stmt.setString(2, nomeFunc);
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_data_user_func\n" + e.getMessage());
        }
    }
}
