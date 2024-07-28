package me.cauadeveloper.commands.group.individual;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.nio.channels.Channel;

public class AdicionarMembroAoTime extends ListenerAdapter {

    //Vou usar um comando para ler um txt que me retorne os nomes dos funcionarios para inserir os idTimes na tabela funcionario


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] command = event.getMessage().getContentRaw().split(" ", 2);
        MessageChannel channel = event.getChannel();

        if (command[0].equalsIgnoreCase("!adicionarMembros")){

            if (command.length < 2){
                channel.sendMessage("Porfavor, forneça o nome do time para adicionar os funcionários!!!").queue();
            }else{
                //Aqui vai retornar o arquivo txt para ser preenchido
            }

        }

    }
}
