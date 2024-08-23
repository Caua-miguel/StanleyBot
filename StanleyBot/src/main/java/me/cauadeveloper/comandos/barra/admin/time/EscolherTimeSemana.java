package me.cauadeveloper.comandos.barra.admin.time;

import me.cauadeveloper.sqlite.tabelas.TabelaTime;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.sql.SQLException;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static me.cauadeveloper.sqlite.consulta.geral.ContadorLinhasTabela.maxLinesTableTime;
import static me.cauadeveloper.utils.constantes.VariaveisAuxiliares.currentID;


public class EscolherTimeSemana extends ListenerAdapter {

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            public void run() { System.out.println("beep"); }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 2, 3, SECONDS);
    }

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
                    TabelaTime.update();
                    currentID++;
                    String nomeGrupo = TabelaTime.select();
                    event.getChannel().sendMessage("Seu grupo da semana é: " + nomeGrupo).queue();


                }else{
                    beepForAnHour();
                    TabelaTime.update();
                    currentID++;
                    String nomeGrupo = TabelaTime.select();
                    event.getChannel().sendMessage("Seu grupo da semana é: " + nomeGrupo).queue();
                }
                event.reply("Olá!").queue();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
