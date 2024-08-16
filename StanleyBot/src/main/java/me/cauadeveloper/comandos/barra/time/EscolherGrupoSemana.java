package me.cauadeveloper.comandos.barra.time;

import me.cauadeveloper.sqlite.tabelas.table_time;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.geral.countLinesTable.maxLinesTableTime;
import static me.cauadeveloper.utils.valores_fixos.utilsStaticMethods.currentID;


public class EscolherGrupoSemana extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();


        if(content.equalsIgnoreCase("!EscolherGPSemana")) {

            try {

                if (currentID > maxLinesTableTime()){
                    currentID = 1;
                    table_time.updateAll();
                    channel.sendMessage("Todos os grupos já foram escolhidos, use o comando novamente para iniciarmos novamente a sequencia de grupos!").queue();
                }else{
                    table_time.update();
                    currentID++;
                    String nomeGrupo = table_time.select();
                    channel.sendMessage("Seu grupo da semana é: " + nomeGrupo).queue();

                }




            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
