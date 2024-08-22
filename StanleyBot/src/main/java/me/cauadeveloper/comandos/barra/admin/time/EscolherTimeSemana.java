package me.cauadeveloper.comandos.barra.admin.time;

import me.cauadeveloper.sqlite.tabelas.TabelaTime;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.geral.ContadorLinhasTabela.maxLinesTableTime;
import static me.cauadeveloper.utils.constantes.VariaveisAuxiliares.currentID;


public class EscolherTimeSemana extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if(event.getUser().isBot()) return;
        String command = event.getName();
        Member member = event.getMember();

        if (member == null) {
            event.reply("Não foi possível identificar o membro.").setEphemeral(true).queue();
            return;
        }

        if (!member.hasPermission(Permission.ADMINISTRATOR)){
            event.reply("Você não tem permissão para usar esse comando!").setEphemeral(true).queue();
            return;
        }

        if (command.equalsIgnoreCase("escolher_time_da_semana")){

            try {
                if (currentID > maxLinesTableTime()){
                    currentID = 1;
                    TabelaTime.updateAll();
                    event.getChannel().sendMessage("Todos os grupos já foram escolhidos, use o comando novamente para iniciarmos novamente a sequencia de grupos!").queue();
                }else{
                    TabelaTime.update();
                    currentID++;
                    String nomeGrupo = TabelaTime.select();
                    event.getChannel().sendMessage("Seu grupo da semana é: " + nomeGrupo).queue();

                }
                event.reply("oi").queue();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
