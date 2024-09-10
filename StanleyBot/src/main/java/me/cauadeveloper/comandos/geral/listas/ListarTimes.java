package me.cauadeveloper.comandos.geral.listas;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListaTimes.selectAllNomeTime;

public class ListarTimes extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();

        if (command.equalsIgnoreCase("listar_times")){

            try {

                StringBuilder stringBuilder = new StringBuilder();
                ArrayList<String> list = selectAllNomeTime();

                for (int i = 0; i < list.size(); i++){
                    stringBuilder.append(list.get(i));
                    if (i < list.size() - 1){
                        stringBuilder.append("\n");
                    }
                }
                event.reply("**Lista dos times cadastrados:**\n" +  stringBuilder.toString()).setEphemeral(true).queue();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return;
        }
    }

}
