package me.cauadeveloper.comandos.geral;

import me.cauadeveloper.sqlite.tabelas.TabelaTime;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.sql.SQLException;

public class TimeSemana extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();

        if (command.equalsIgnoreCase("time_da_semana")){

            try {

                if(TabelaTime.select() != null){
                    String nomeGrupo = TabelaTime.select();
                    event.reply("Seu grupo da semana é: " + nomeGrupo).setEphemeral(true).queue();

                }else{
                    event.reply("Nenhum time da semana foi escolhido. Use o comando `/escolher_time_da_semana` para escolher um time e depois" +
                            " você vai poder visualizar o time da semana com `/time_da_semana`.").setEphemeral(true).queue();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return;
        }


    }
}
