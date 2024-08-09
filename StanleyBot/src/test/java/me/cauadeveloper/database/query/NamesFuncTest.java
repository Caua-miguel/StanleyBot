package me.cauadeveloper.database.query;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.database.query.collumn_names.allNamesFunc.selectIdNomesFunc;

public class NamesFuncTest {

    @Test
    @DisplayName("Resultado para a query que retorna as colunas id e nome da tabela funcionario")
    public void saidaDoArrayComIntegerESring() throws SQLException {

        System.out.println(selectIdNomesFunc());

        ArrayList<Object> listaFunc = selectIdNomesFunc();

        for (int i = 0; i < listaFunc.size()-1; i++){
            System.out.println(listaFunc.get(i) + " - " + listaFunc.get(i + 1));
        }


    }

}
