package me.cauadeveloper.sqlite.inserir;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListaTarefas.selectUmaDescTarefas;


public class NovaTarefaTest {

    @Test
    public void aidicionarTarefa(){

        try {
            System.out.println(selectUmaDescTarefas(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
