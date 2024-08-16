package me.cauadeveloper.comandos.barra.time;

import me.cauadeveloper.sqlite.tabelas.table_time;
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

                    if(table_time.select() != null){
                        String nomeGrupo = table_time.select();
                        channel.sendMessage("Seu grupo da semana é: " + nomeGrupo).queue();

                    }else{
                        channel.sendMessage("Nenhum grupo da semana foi escolhido. Use o comando **!EscolherGPSemana** para escolher um grupo e depois" +
                                " você vai poder visualizar o grupo da semana com **!GPSemana**.").queue();
                    }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
