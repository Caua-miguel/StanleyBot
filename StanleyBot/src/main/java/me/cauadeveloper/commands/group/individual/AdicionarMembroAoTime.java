package me.cauadeveloper.commands.group.individual;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.nio.channels.Channel;
import java.util.ArrayList;

import static me.cauadeveloper.utils.files.member.inputMemberOnTeam.inputMemberDefault;
import static me.cauadeveloper.utils.files.member.outputMemberTeam.writeFileDefaltMember;

public class AdicionarMembroAoTime extends ListenerAdapter {

    // Vai ser um slash command - o usuário tem que conseguir escolher os nomes dos funcionários que foram adicionados na tabela inicial
    // e os funcionários que ele escoleher vai ajustar o idTime da tabela funcionário de acordo com o id dos times.

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] command = event.getMessage().getContentRaw().split(" ", 2);
        MessageChannel channel = event.getChannel();
        File file = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/database/assents/MembersTeam.pdf");
        FileUpload fileUpload = FileUpload.fromData(file);

        if (command[0].equalsIgnoreCase("!startMembros")){

            if (command.length < 2){
                channel.sendMessage("Porfavor, forneça o nome do time para adicionar os funcionários!!!").queue();
            }else{

                writeFileDefaltMember(command[1]);
                channel.sendMessage("Por favor escreva o nome de todos os funcionários que fazem parte do time " + command[1]).addFiles(fileUpload).queue();



            }

        }

    }
}
