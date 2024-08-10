package me.cauadeveloper.database.update;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static me.cauadeveloper.database.query.collumn_names.NamesTeam.selectNomeTime;

public class funcionario {

    public static void updateFuncionario(int id, String nomeFunc, String nomeTime) throws SQLException{

        String sql = """
                UPDATE funcionario set nome = ?, idTime = ? WHERE id = ?
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            int idTime = selectNomeTime(nomeTime);

            if (idTime != -1){
                stmt.setString(1, nomeFunc);
                stmt.setInt(2, idTime);
                stmt.setInt(3, id);
                stmt.executeUpdate();
            }else {
                throw new SQLException();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }

    }

}
