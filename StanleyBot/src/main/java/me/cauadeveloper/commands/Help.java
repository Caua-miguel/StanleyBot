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
                    "Os comandos que nós temos são os seguintes:\n\n 1 - !createRoleEmpty\n 2 - !createRoleDefault\n 3 - !createCopyRole\n");
            embed.addField("Cargo Vazio", "O comando **!createRoleEmpty** é usando quando você precisa criar um novo cargo" +
                    " no seu servidor, mas sem nenhuma permissão, para que você configure de acordo com a sua necessidade. \n\nformato: **<!createRoleEmpty> <nome do cargo>**"
                    , false);
            embed.addField("Cargo Padrão", "O comando **!createRoleDefault** é usando quando você precisa criar um novo cargo" +
                    " no seu servidor com as mesmas permissões do cargo everyone para agilizar a configuração das permissões. \n\nformato: **<!createRoleDefault> <nome do cargo>**"
                    , false);
            embed.addField("Copia de cargo", " O comando **!createRoleDefault** é usando quando você precisa criar um novo cargo" +
                    " , mas quer copiar as permissões de outro cargo para ter como base. \n\nformato: **<!createRoleDefault> <nome do novo cargo> <nome do cargo que deseja copiar>**" +
                    " \n\n Os outros comandos são inutei ou vão ser reformulados, por isso não adicionei aqui.", false);
            channel.sendMessageEmbeds(embed.build()).queue();
        }


    }
}
