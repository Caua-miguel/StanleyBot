package me.cauadeveloper.commands;

import me.cauadeveloper.database.tables.Table_Time;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.sql.SQLException;

public class GrupoSemana extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();


        if(content.equalsIgnoreCase("!GPSemana")) {

            try {

                    String nomeGrupo = Table_Time.selectID();
                    channel.sendMessage("Seu grupo da semana é: " + nomeGrupo).queue();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
