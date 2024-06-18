package me.cauadeveloper.database.tables.refact;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class table_time {

    public static void create_table () throws SQLException{

        String sql = """
                CRESTE TABLE time (
                    id integer AUTOINCREMENT PRIMARY KEY NOT NULL,
                    nome varchar(255) NOT NULL,
                    status boolean NOT NULL
                )
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            stmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
