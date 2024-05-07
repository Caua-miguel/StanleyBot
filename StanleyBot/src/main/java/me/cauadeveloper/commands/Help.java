package me.cauadeveloper.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();
        EmbedBuilder embed = new EmbedBuilder();

        if(content.equalsIgnoreCase("!help")){

            embed.setTitle("Help");
            embed.setDescription("O StanleyBot é seu auxiliar na preparação do seu café.\n\n" +
                    "Os comandos que nós temos são os seguintes:\n\n 1 - !createRole\n 2 - !goodNight\n 3 - !ping\n");
            embed.addField("Novo cargo", "O comando **!createRole** é usando quando você precisa criar um novo cargo" +
                    " no seu servidor. \n\nformato: **<!createRole> <nome do cargo>**" +
                    "\n\n Os outros comandos são inutei ou vão ser reformulados, por isso não adicionei aqui.", false);
            channel.sendMessageEmbeds(embed.build()).queue();
        }


    }
}
