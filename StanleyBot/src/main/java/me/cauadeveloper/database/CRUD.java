package me.cauadeveloper.database;

import me.cauadeveloper.bot.StanleyBot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    public static void  select(String guildId) throws SQLException{

        String sql = """
                    select * from tb_guild where guild_id = %s
                    """.formatted(guildId);
        Statement stmt = ConnectionFactory.getConn().createStatement();

        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next()){
            StanleyBot.prefixMap.put(guildId, resultSet.getString("prefix").charAt(0));
        }

        stmt.close();
        ConnectionFactory.getConn().close();

    }

    public static void insert(String guildId, char prefix) throws SQLException{

        String sql = """
                      insert or ignore into tb_guild values (null, '%s', '%s')
                      """.formatted(guildId, prefix);
        Statement stmt = ConnectionFactory.getConn().createStatement();
        stmt.execute(sql);
        stmt.close();
        ConnectionFactory.getConn().close();
    }

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
