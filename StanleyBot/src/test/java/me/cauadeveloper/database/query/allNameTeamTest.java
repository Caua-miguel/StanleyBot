package me.cauadeveloper.database.query;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.database.query.tables.NamesTeam.selectAllNomeTime;
import static me.cauadeveloper.database.query.tables.NamesTeam.selectNomeTime;


public class allNameTeamTest {

    @Test
    @DisplayName("Saida de todos os nomes dos times")
    public void printAllNamesTeam() throws SQLException {

        ArrayList<String> nomeTime = selectAllNomeTime();
        System.out.println(nomeTime);

    }

    @Test
    @DisplayName("Saida do idTime de acordo com o nome do time")
    public void printIdTime() throws SQLException {

        System.out.println(selectNomeTime("coaLegal"));

    }


}
