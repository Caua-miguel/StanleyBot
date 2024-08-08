package me.cauadeveloper.database.insert;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static me.cauadeveloper.database.query.general.checkTablesAreNull.check_if_tableFunc_is_null;

public class novo_funcionario {

    public static void insert_novo_func(String func) throws SQLException {
        String sql = """
                INSERT INTO funcionario(id, nome) values (?,?)
                """;
        int contCollumnIdFunc = check_if_tableFunc_is_null();
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){


            stmt.setInt(1, contCollumnIdFunc + 1);
            stmt.setString(2, func);

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }
    }

}
