package me.cauadeveloper.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class goodNight extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();

        if(content.equals("!boa noite")){

            MessageChannel channel = event.getChannel();
            channel.sendMessage("Tenha um ótimo soninho!").queue();

        }

    }
}
