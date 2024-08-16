package me.cauadeveloper.sqlite.remover;

import me.cauadeveloper.sqlite.config_banco.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class removerFunc {

    public static void removerFunc(int id) throws SQLException {

        String sql = """
                DELETE FROM funcionario WHERE id = ?
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.execute();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }

    }

}
