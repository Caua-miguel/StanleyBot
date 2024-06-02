package me.cauadeveloper.commands.task;

import me.cauadeveloper.database.tables.Table_Time;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.sql.SQLException;

public class ReportarFaltaRecurso extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {


        String [] command = event.getMessage().getContentRaw().split(" ", 2);
        MessageChannel channel = event.getChannel();

        if(command[0].equalsIgnoreCase("!ReportarFalta")) {

            if (command.length < 2) {
                event.getChannel().sendMessage("Por favor, forneça o nome do item.").queue();
            } else {
                try {

                    String nomeGrupo = Table_Time.selectID();

                    channel.sendMessage("Olá, pessoal. Estamos reportando a falta do item: **__" + command[1] + "__**\nTime **__"  + nomeGrupo +
                            "__**, poderia selecionar alguém para fazer a reposição?").queue();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
