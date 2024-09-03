package me.cauadeveloper.comandos.geral;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if(event.getUser().isBot()) return;
        String command = event.getName();
        long BotPing =  event.getJDA().getGatewayPing();

        if (command.equalsIgnoreCase("ping")){
            event.reply(BotPing + " ms").queue();
            return;
        }
    }
}





