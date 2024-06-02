package me.cauadeveloper.commands.group;

import me.cauadeveloper.database.tables.Table_Time;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.sql.SQLException;

// variáveis estáticas

import static me.cauadeveloper.database.tables.Table_Time.currentID;
import static me.cauadeveloper.database.tables.Table_Time.maxLines;

public class EscolherGrupoSemana extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();


        if(content.equalsIgnoreCase("!EscolherGPSemana")) {

            try {

                if (currentID >= maxLines){
                    currentID = 0;
                    Table_Time.updateAll();
                    channel.sendMessage("update de toda a coluna realizado com sucesso").queue();
                }else{
                    Table_Time.update();
                    String nomeGrupo = Table_Time.selectID();
                    channel.sendMessage("Seu grupo da semana é: " + nomeGrupo).queue();
                    channel.sendMessage("update com sucesso").queue();
                }




            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
