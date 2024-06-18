package me.cauadeveloper.database.tables.versionOne;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.util.Objects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table_Time {

    public static int currentID = 0;
    public static int maxLines = 3;

    public static String selectID() throws SQLException{

        String sql = """
                      select nome_time from Time where TimeID = ?
                      """;

       try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){


                   stmt.setInt(1, currentID);

                   ResultSet resultSet = stmt.executeQuery();

                   while (resultSet.next()){
                       return resultSet.getString("nome_time");
                   }


       }catch (SQLException e) {
           e.printStackTrace();

       }

        return null;

    }


    public static void update() throws SQLException{

        currentID++;

        if (currentID > maxLines){
            currentID = 1;
        }

            try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement("update Time set statusTime = ? where TimeID = ?")){

                stmt.setString(1, "false");
                stmt.setInt(2, currentID);
                stmt.execute();

            }catch (SQLException e) {
                e.printStackTrace();
            }


    }

    public static void updateAll() throws SQLException{


        try (PreparedStatement updateStmt = ConnectionFactory.getConn().prepareStatement("update Time set statusTime = ?")){
            updateStmt.setString(1, "true");
            updateStmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static void insert(int timeID, String nome_time, boolean statusTime) throws SQLException {

        String sql = """
                      insert or ignore into Time values (?, ?, ?)
                      """;
        try (PreparedStatement stmt = Objects.requireNonNull(ConnectionFactory.getConn()).prepareStatement(sql)){


            stmt.setInt(1, timeID);
            stmt.setString(2, nome_time);
            stmt.setString(3, String.valueOf(statusTime));

            stmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }


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


