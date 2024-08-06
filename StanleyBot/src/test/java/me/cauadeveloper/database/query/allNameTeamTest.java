package me.cauadeveloper.database.query;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.database.query.collumn_names.allNamesTeam.selectNomeTime;


public class allNameTeamTest {

    @Test
    @DisplayName("Saida de todos os nomes dos times")
    public void printAllNamesTeam() throws SQLException {

        ArrayList<String> nomeTime = selectNomeTime();
        System.out.println(nomeTime);

    }


}
