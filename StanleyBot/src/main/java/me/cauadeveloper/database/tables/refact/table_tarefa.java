package me.cauadeveloper.database.tables.refact;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class table_tarefa {

    public static void create_table() throws SQLException {

        String sql = """
                CREATE TABLE tarefa(
                    id integer AUTOINCREMENT PRIMARY KEY NOT NULL,
                    descricao varchar NOT NULL
                )
                """;
        try (PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
