package me.cauadeveloper.database.update;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateFunc {

    public static void updateFuncionario(int id, String nomeFunc) throws SQLException{

        String sql = """
                UPDATE funcionario set nome = ? WHERE id = ?
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

                stmt.setString(1, nomeFunc);
                stmt.setInt(2, id);
                stmt.executeUpdate();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }

    }

}