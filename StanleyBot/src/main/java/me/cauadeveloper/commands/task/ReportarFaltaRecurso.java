package me.cauadeveloper.commands.task;

import me.cauadeveloper.database.tables.table_time;
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
                channel.sendMessage("Por favor, forneça o nome do item.").queue();
            } else {
                try {

                    if(table_time.select() != null){
                        String nomeGrupo = table_time.select();
                        channel.sendMessage("Olá, pessoal. Estamos reportando a falta do item: **__" + command[1] + "__**\nTime **__"  + nomeGrupo +
                                "__**, poderia selecionar alguém para fazer a reposição?").queue();
                    }else{
                        String nomeGrupo = "Escolham o time da semana para que a tarefa possa ser atribuída a algum time.";
                        channel.sendMessage("Olá, pessoal. Estamos reportando a falta do item: **__" + command[1] + "__**." +
                                "\n**__"  + nomeGrupo + "__**").queue();
                    }


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
