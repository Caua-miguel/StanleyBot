package me.cauadeveloper.commands.group;

import me.cauadeveloper.database.tables.refact.table_time;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.sql.SQLException;
import static me.cauadeveloper.Utils.utilsStaticMethods.currentID;
import static me.cauadeveloper.Utils.utilsStaticMethods.maxLines;


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
                    table_time.updateAll();
                    channel.sendMessage("update de toda a coluna realizado com sucesso").queue();
                }else{
                    table_time.update();
                    String nomeGrupo = table_time.select();
                    channel.sendMessage("Seu grupo da semana é: " + nomeGrupo).queue();
                    channel.sendMessage("update com sucesso").queue();
                }




            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
