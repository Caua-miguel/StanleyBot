package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Table_Time_Tarefa {

    public static void insert(int timeTarefaID,int TimeID, int TarefaID, boolean status) throws SQLException {

        String sql = """
                      insert or ignore into time_tarefa values ('%s', '%s', '%s', '%s')
                      """.formatted(timeTarefaID, TimeID, TarefaID, status);
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }

    public static void createTableTimeTarefa() throws SQLException {

        String sql = """
                    create table if not exists time_tarefa
                    (
                        timeTarefaID integer not null primary key autoincrement unique,
                        TimeID integer,
                        TarefaID integer,
                        status boolean not null,
                        FOREIGN KEY (TimeID) REFERENCES Time(id),
                        FOREIGN KEY (TarefaID) REFERENCES Tarefa(id)
                    )""";
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }
}


