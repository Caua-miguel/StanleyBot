package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Table_Funcionario_Grupo {

    public static void insert(int funcionarioGrupoID,int funcionarioID, int timeID, boolean status) throws SQLException {

        String sql = """
                      insert or ignore into funcionarios_grupo values ('%s', '%s', '%s', '%s')
                      """.formatted(funcionarioGrupoID, funcionarioID, timeID, status);
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
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


