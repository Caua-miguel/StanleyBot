package me.cauadeveloper.sqlite.consulta;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListaTarefas.selectListaTarefas;

public class ListaTarefasTest {

    @Test
    @DisplayName("Saída da lista de tarefas")
    public void saidaListaTarefas() throws SQLException {

        System.out.println(selectListaTarefas());

    }

}
