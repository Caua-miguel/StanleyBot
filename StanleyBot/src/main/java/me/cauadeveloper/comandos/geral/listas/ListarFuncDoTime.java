package me.cauadeveloper.comandos.geral.listas;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import java.sql.SQLException;
import java.util.ArrayList;
import static me.cauadeveloper.sqlite.consulta.tabelas.ListaFunc.selectRelacaoFuncTime;
import static me.cauadeveloper.sqlite.consulta.tabelas.ListaTimes.selectIdTime;

public class ListarFuncDoTime extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping nomeTimeOption = event.getOption("nome_time");

        if (command.equalsIgnoreCase("listar_funcionarios_do_time")){

            try {

                String nomeTime = nomeTimeOption.getAsString();
                StringBuilder stringBuilder = new StringBuilder();
                int idTime = selectIdTime(nomeTime);
                ArrayList<String> list = selectRelacaoFuncTime(idTime);

                for (int i = 0; i < list.size(); i++){
                    stringBuilder.append(list.get(i));
                    if (i < list.size() - 1){
                        stringBuilder.append("\n");
                    }
                }
                event.reply("**Lista dos funcionários que fazem parte do time `" + nomeTime +"`:**\n" +  stringBuilder.toString()).setEphemeral(true).queue();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return;
        }
    }
}
