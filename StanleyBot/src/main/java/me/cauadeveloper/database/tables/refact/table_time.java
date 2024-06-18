package me.cauadeveloper.database.tables.refact;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static me.cauadeveloper.Utils.utilsStaticMethods.currentID;

public class table_time {

    public static String select() throws SQLException{

        String sql = """
                SELECT nome from time where id = ?
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            stmt.setInt(1, currentID);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                return resultSet.getString("nome");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void update() throws SQLException{

        String sql = """
                UPDATE time set status = 'false' where id = ?
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            stmt.setInt(1, currentID);
            stmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateAll() throws SQLException{

        String sql = """
                UPDATE time set status = 'true'
                """;

        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

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
