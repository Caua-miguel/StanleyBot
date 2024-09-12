package me.cauadeveloper.comandos.geral.listas;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListaFunc.selectNomeFunc;

public class ListarFuncionarios extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();

        if (command.equalsIgnoreCase("listar_funcionario")){

            try {

                StringBuilder stringBuilder = new StringBuilder();
                ArrayList<String> list = selectNomeFunc();

                for (int i = 0; i < list.size(); i++){
                    stringBuilder.append(list.get(i));
                    if (i < list.size() - 1){
                        stringBuilder.append("\n");
                    }
                }
                event.reply("**Lista dos funcionários cadastrados:**\n" +  stringBuilder).setEphemeral(true).queue();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return;
        }
    }

}
