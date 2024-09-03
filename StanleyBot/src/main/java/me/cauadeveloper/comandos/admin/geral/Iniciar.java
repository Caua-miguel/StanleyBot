package me.cauadeveloper.comandos.admin.geral;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

import java.awt.*;
import java.io.InputStream;

public class Iniciar extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        EmbedBuilder embed = new EmbedBuilder();
        InputStream inputStream = Iniciar.class.getClassLoader().getResourceAsStream("grupos.xls");
        FileUpload fileUpload = FileUpload.fromData(inputStream, "grupos.xls");
        Member member = event.getMember();

        if (member == null) {
            event.reply("Não foi possível identificar o membro.").setEphemeral(true).queue();
            return;
        }

        if (!member.hasPermission(Permission.ADMINISTRATOR)){
            event.reply("Você não tem permissão para usar esse comando!").setEphemeral(true).queue();
            return;
        }

        if(command.equalsIgnoreCase("iniciar")){

            embed.addField("**Stanley Bot**","Olá, meu nome é Stanley e eu vou ajudar você a gerenciar o preparo do café para que você e seus" +
                    "colegas de equipe possam trabalhar sem se preocupar com a falta de café.\n\n Primeiro me deixe conhecer os integrates da equipe, os nomes" +
                    "que vocês vão usar para os times e quais tarefas vocês querem a minha ajuda.\n\n Para isso vou precisar da sua ajuda, preencha o arquivo abaixo" +
                    "como uma tabela, vou pedir para que coloque os nomes dos funcionários, um por linha, na coluna **A**. O nome dos times, um por linha na coluna **E** e as" +
                    "descrições, uma por linha na coluna **I**.\n\n Assim que vocẽ terminar, vai precisar rodar o comando `/inserir_dados_iniciais` me develvendo o arquivo editado." +
                    "\n\nAssim eu vou saber dos nomes que preciso. A partir dai, podemos começar.",false);
            embed.setColor(Color.decode("#58CCD6"));
            event.replyEmbeds(embed.build()).addFiles(fileUpload).setEphemeral(true).queue();

        }

    }
}
