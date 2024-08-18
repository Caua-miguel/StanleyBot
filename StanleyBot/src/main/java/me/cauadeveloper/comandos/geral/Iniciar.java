package me.cauadeveloper.comandos.geral;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;

public class Iniciar extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();
        EmbedBuilder embed = new EmbedBuilder();
        File file = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/sqlite/recursos/grupos.xls");
        FileUpload fileUpload = FileUpload.fromData(file);

        if(content.equalsIgnoreCase("!Start")){

                embed.addField("**Stanley Bot**","Olá, meu nome é Stanely e eu vou ajudar você a gerenciar o preparo do café para que você e seus" +
                        "colegas de equipe possam trabalhar sem se preocupar com a falta de café.\n Primeiro me deixe conhecer os integrates da equipe, os nomes" +
                        "que vocês vão usar para os times e quais tarefas vocês querem a minha ajuda. Para isso vou precisar da sua ajuda, preencha o arquivo abaixo" +
                        "como uma tabela, vou pedir para que coloque os nomes dos funcionários, um por linha, na coluna **A**. O nome dos times, um por linha na coluna **E** e as" +
                        "dedscrições, uma por linha na coluna **I**. Assim que vocẽ terminar, vai precisar rodar o comando ... <anexo> me develvendo o arquivo editado" +
                        "assim eu vou saber dos nomes que preciso. A partir dai, podemos começar.",false);
            channel.sendMessageEmbeds(embed.build()).queue();
            channel.sendFiles(fileUpload).queue();

        }

    }


}
