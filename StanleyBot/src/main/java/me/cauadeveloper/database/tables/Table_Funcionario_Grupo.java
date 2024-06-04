package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table_Funcionario_Grupo {

    public static void insert(int funcionarioGrupoID, boolean status) throws SQLException {


        // Insert errado
        String sql = """
                  INSERT OR IGNORE INTO funcionarios_grupo (funcionarioGrupoID, funcionarioID, TimeID, status)
                  SELECT ?, funcionarios_omega.funcionarioID, Time.TimeID, ? FROM funcionarios_omega
                  JOIN Time ON funcionarios_omega.funcionarioID = Time.TimeID
                  """;

        try (PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql)) {

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){

            }

            stmt.setInt(1, funcionarioGrupoID);
            stmt.setString(2, String.valueOf(status));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTableFuncionariosGrupo() throws SQLException {

        String sql = """
                    create table if not exists funcionarios_grupo
                    (
                        funcionarioGrupoID integer not null primary key autoincrement unique,
                        funcionarioID integer,
                        TimeID integer,
                        status boolean not null,
                        FOREIGN KEY (funcionarioID) REFERENCES funcionarios_omega(id),
                        FOREIGN KEY (TimeID) REFERENCES Time(id)
                    )""";
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }
}


