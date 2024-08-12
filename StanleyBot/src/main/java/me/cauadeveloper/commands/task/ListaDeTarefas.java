package me.cauadeveloper.commands.task;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.database.query.tables.ListaTarefas.selectListaTarefas;

public class ListaDeTarefas extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();

        if(content.equalsIgnoreCase("!ListaTarefas")) {

            try {
                ArrayList<String> list = selectListaTarefas();

                channel.sendMessage("Segue a lista de tarefas cadastradas:\n").queue();
                for (int i = 0; i < list.size(); i++){

                    channel.sendMessage("\n" + list.get(i)).queue();

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
