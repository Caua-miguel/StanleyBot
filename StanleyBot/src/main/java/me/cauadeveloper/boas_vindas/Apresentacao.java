package me.cauadeveloper.boas_vindas;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Apresentacao extends ListenerAdapter {

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Guild guild = event.getGuild();
        List<TextChannel> channelList = guild.getTextChannelsByName("geral", true);

        // Verifica se a lista não está vazia
        if (!channelList.isEmpty()) {
            TextChannel textChannel = channelList.get(0);
            textChannel.sendMessage("Olá, eu sou o Stanley, seu ajudante de gerenciamento de equipes para o preparo do café." +
                    " Para começarmos vou precisar que você, **administrador do servidor**, me passe o nome de cada pessoa da sua equipe e o nome" +
                    " de cada equipe.\n\nComo fazer isso?\n\nUse o comando **!start** para receber todas as instruções.").queue();
        } else {
            // Caso não haja um canal com o nome "geral", você pode querer lidar com isso aqui
            System.out.println("Nenhum canal 'geral' encontrado.");
        }
    }
}
