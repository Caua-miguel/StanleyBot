package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Table_Time {

    public static void insert(int timeID, String nome_time, boolean statusTime) throws SQLException {

        String sql = """
                      insert or ignore into Time values ('%s', '%s', '%s')
                      """.formatted(timeID, nome_time, statusTime);
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }

    public static void createTableTime() throws SQLException {

        String sql = """
                    create table if not exists Time
                    (
                        TimeID integer not null primary key autoincrement unique,
                        nome_time varchar(50) not null,
                        statusTime boolean not null
                    )""";
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }
}


