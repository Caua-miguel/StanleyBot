package me.cauadeveloper.database;

import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    public static void createTable() throws SQLException {

        String sql = """
                    create table tb_guild
                    (
                        id integer not null primary key autoincrement unique,
                        guild_id text not null unique,
                        prefix text not null
                    )""";
        Statement stmt = ConnectionFactory.getConn().createStatement();
        stmt.execute(sql);
        stmt.close();
        ConnectionFactory.getConn().close();
    }

}
