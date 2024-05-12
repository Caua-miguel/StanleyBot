package me.cauadeveloper.commands;

import me.cauadeveloper.bot.StanleyBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Prefix extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();

        if(content.equalsIgnoreCase(StanleyBot.prefixMap.get(event.getGuild().getId()) + "prefix")){

            channel.sendMessage("O prefixo para este servidor é: " + StanleyBot.prefixMap.get(event.getGuild().getId())).queue();

        }
    }
}
