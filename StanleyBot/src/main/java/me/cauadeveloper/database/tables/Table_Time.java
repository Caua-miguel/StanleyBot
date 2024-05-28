package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.util.Objects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table_Time {

    private static int currentID = 0;

    public static String selectID() throws SQLException{

       // int maxLines = 3;

        String sql = """
                      select nome_time from Time where TimeID = ?
                      """;
        PreparedStatement stmt = Objects.requireNonNull(ConnectionFactory.getConn()).prepareStatement(sql);

//        currentID++;
//
//        if (currentID > maxLines){
//            currentID = 1;
//        }

        stmt.setInt(1, currentID);

        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()){
            return resultSet.getString("nome_time");
        }
        resultSet.close();
        stmt.close();
        ConnectionFactory.getConn().close();
        return null;
    }

    public static void update() throws SQLException{

        int maxLines = 3;

        currentID++;

        if (currentID > maxLines){
            currentID = 1;
        }

        String sql = """
                      update Time set statusTime = ? where TimeID = ?
                      """;
        PreparedStatement stmt = Objects.requireNonNull(ConnectionFactory.getConn()).prepareStatement(sql);
        stmt.setString(1, "true");
        stmt.setInt(2, currentID);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }


    public static void insert(int timeID, String nome_time, boolean statusTime) throws SQLException {

        String sql = """
                      insert or ignore into Time values ('%s', '%s', '%s')
                      """.formatted(timeID, nome_time, statusTime);
        PreparedStatement stmt = Objects.requireNonNull(ConnectionFactory.getConn()).prepareStatement(sql);
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
        PreparedStatement stmt = Objects.requireNonNull(ConnectionFactory.getConn()).prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }

}


