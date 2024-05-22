package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table_Time {


    public static String selectID(int TimeID) throws SQLException{

        String sql = """
                      select nome_time from Time where TimeID = ('%s')
                      """.formatted(TimeID);
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()){
            String nomeTime = resultSet.getString("nome_time");
            return nomeTime;
        }

        stmt.close();
        ConnectionFactory.getConn().close();
        return null;
    }

    public static void update(boolean statusTime, int TimeID) throws SQLException{

        String sql = """
                      update Time set statusTime = ('%s') where TimeID = ('%s')
                      """.formatted(statusTime, TimeID);
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }


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


