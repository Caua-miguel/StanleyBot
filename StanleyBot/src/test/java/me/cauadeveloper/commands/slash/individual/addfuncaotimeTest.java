package me.cauadeveloper.commands.slash.individual;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.database.query.collumn_names.allNamesFunc.selectNomeFunc;
import static me.cauadeveloper.database.query.collumn_names.allNamesTeam.selectNomeTime;

public class addfuncaotimeTest {
    
    @Test
    @DisplayName("Testar os loops e as variáveis nomeTime e nomeFunc")
    public void loopsAndVarNomeTimeNomeFunc() throws SQLException {

        ArrayList<String> nomeTime;
        ArrayList<String> nomeFunc;

        nomeTime = selectNomeTime();
        nomeFunc = selectNomeFunc();
        int i;
        String dadoArmazenado = "";
        
        for (i = 0; i < nomeTime.size(); i++){

            if (i == 0){
                dadoArmazenado = nomeTime.get(i);
            }
            
        }

        i = 0;

        for (int j = 0; j < nomeFunc.size(); j++){

            String dadoFunc;
            System.out.println(i);
            
            if (j == 1){
                dadoFunc = nomeFunc.get(j);
                System.out.println("Nome do funcionario na posição j: " + dadoFunc + " e o indice: " + j + "\n Nome do time na posição i: " + dadoArmazenado + " e o indice: " + i);
            }

        }
        
    }
    
}
