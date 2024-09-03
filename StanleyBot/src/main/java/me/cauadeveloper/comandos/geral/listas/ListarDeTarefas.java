package me.cauadeveloper.comandos.geral.listas;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListarTarefas.selectListaTarefas;

public class ListarDeTarefas extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();

        if (command.equalsIgnoreCase("listar_tarefas")){

            try {

                StringBuilder stringBuilder = new StringBuilder();
                ArrayList<String> list = selectListaTarefas();

                for (int i = 0; i < list.size(); i++){
                    stringBuilder.append(list.get(i));
                    if (i < list.size() - 1){
                        stringBuilder.append("\n");
                    }
                }
                event.reply("Lista das tarefas:\n\n" +  stringBuilder.toString()).setEphemeral(true).queue();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
         return;
        }
    }
}
