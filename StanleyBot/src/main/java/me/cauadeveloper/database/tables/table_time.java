package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static me.cauadeveloper.database.dataconfig.readConfig.dataUserCollumnE;
import static me.cauadeveloper.utils.fixValues.utilsStaticMethods.currentID;

public class table_time {

    public static void insert_data_user_time(String[] dataUser) throws SQLException{

        String sql = """
                INSERT INTO time(nome, status) values (?, ?)
                """;
        try(PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)){

            String[] data;
            data = dataUser;

            for (int i = 0; i <= data.length-1; i++){
                stmt.setString(1, data[i]);
                stmt.setString(2, "true");
                stmt.execute();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_data_user_time\n" + e.getMessage());
        }
    }

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
