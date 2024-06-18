package me.cauadeveloper.database.tables.refact;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class table_time {

    public static void update() throws SQLException{

        String sql = """
                UPDATE time set status = 'false' where id = ?
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            stmt.setInt(1, 1);
            stmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void create_table () throws SQLException{

        String sql = """
                CREATE TABLE time (
                    id integer PRIMARY KEY AUTOINCREMENT NOT NULL,
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
