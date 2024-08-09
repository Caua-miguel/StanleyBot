package me.cauadeveloper.commands.slash.config;

import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static me.cauadeveloper.database.query.collumn_names.NamesTeam.selectAllNomeTime;
import static me.cauadeveloper.database.query.collumn_names.allNamesFunc.selectNomeFunc;

public class SetMenu {

    ArrayList<String> nomeTime;
    ArrayList<String> nomeFunc;

    public StringSelectMenu menuNomesTimes() throws SQLException {

        nomeTime = selectAllNomeTime();
        List<SelectOption> optionsNomeTime = new ArrayList<>();
        for (int i = 0; i < nomeTime.size(); i++){
            optionsNomeTime.add(SelectOption.of(nomeTime.get(i), nomeTime.get(i)));
        }

        StringSelectMenu menu_time = StringSelectMenu.create("menu_time")
                .setPlaceholder("Escolha uma opção...")
                .addOptions(
                        optionsNomeTime
                )
                .build();

        return menu_time;
    }

    public StringSelectMenu menuNomesFunc() throws SQLException {

        nomeFunc = selectNomeFunc();
        List<SelectOption> optionsNomeFunc = new ArrayList<>();

        for (int cont = 0; cont < nomeFunc.size(); cont++){
            optionsNomeFunc.add(SelectOption.of(nomeFunc.get(cont), nomeFunc.get(cont)));
        }

        StringSelectMenu menu_funcionario = StringSelectMenu.create("menu_atualiza_funcionario")
                .setPlaceholder("Escolha uma opção...")
                .addOptions(
                        optionsNomeFunc
                )
                .build();
        return menu_funcionario;
    }

}
