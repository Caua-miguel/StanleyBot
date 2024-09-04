package me.cauadeveloper.sqlite.consulta;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListarFunc.selectIdFunc;
import static me.cauadeveloper.sqlite.consulta.tabelas.ListarFunc.selectNomeFunc;


public class NamesFuncTest {

    @Test
    @DisplayName("Resultado para a query que retorna as colunas id e nome da tabela funcionario")
    public void saidaDoArrayComIntegerESring() throws SQLException {

        System.out.println(selectNomeFunc());

        ArrayList<String> listaFunc = selectNomeFunc();
        ArrayList<String> listaID = selectIdFunc();

        for (int i = 0; i < listaFunc.size(); i++){

            System.out.print("Selecione o numero que corresponde ao usuário e atualize-o:" + "\n" + listaID.get(i) + " - " + listaFunc.get(i));

        }


    }

}
