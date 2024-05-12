package me.cauadeveloper.commands;

import me.cauadeveloper.bot.StanleyBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ping extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();
        long BotPing =  event.getJDA().getGatewayPing();

        if(content.equalsIgnoreCase(StanleyBot.prefixMap.get(event.getGuild().getIdLong()) + "Ping")) {

            channel.sendMessage(BotPing + " ms").queue();
        }
    }
}





