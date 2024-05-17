package me.cauadeveloper.database.tables;

import me.cauadeveloper.database.dataconfig.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Table_Funcionarios_Omega {

    public static void insert(int funcionarioID, String nome_funcionario) throws SQLException{

        String sql = """
                      insert or ignore into funcionarios_omega values ('%s', '%s')
                      """.formatted(funcionarioID, nome_funcionario);
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }

    public static void createTableFuncionarios() throws SQLException {

        String sql = """
                    create table if not exists funcionarios_omega
                    (
                        funcionarioID integer not null primary key autoincrement unique,
                        nome_funcionario text not null unique
                    )""";
        PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ConnectionFactory.getConn().close();
    }
}

