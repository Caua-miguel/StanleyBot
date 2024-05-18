package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Table_Tarefa {

    public static void insert(int tarefaID, String nome_tarefa) throws SQLException {

        String sql = """
                      insert or ignore into Tarefa values ('%s', '%s')
                      """.formatted(tarefaID, nome_tarefa);
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }

    public static void createTableTarefa() throws SQLException {

        String sql = """
                    create table if not exists Tarefa
                    (
                        TarefaID integer not null primary key autoincrement unique,
                        nome_tarefa varchar not null
                    )""";
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }
}


