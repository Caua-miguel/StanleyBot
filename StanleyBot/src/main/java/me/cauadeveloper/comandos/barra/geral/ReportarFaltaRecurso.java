package me.cauadeveloper.comandos.barra.geral;

import me.cauadeveloper.sqlite.tabelas.TabelaTime;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.sql.SQLException;

public class ReportarFaltaRecurso extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping optionMapping = event.getOption("item_faltante");

        if (command.equalsIgnoreCase("reportar_falta")){

            String item = optionMapping.getAsString();

                try {

                    if(TabelaTime.select() != null){
                        String nomeTime = TabelaTime.select();
                        event.reply("Olá, pessoal. Estamos reportando a falta do item: `" + item + "`\nTime **__"  + nomeTime +
                                "__**, poderia selecionar alguém para fazer a reposição?").queue();
                    }else{
                        String nomeTime = "Escolham o time da semana para que a tarefa possa ser atribuída a algum time.";
                        event.reply("Olá, pessoal. Estamos reportando a falta do item: `" + item + "`." +
                                "\n**__"  + nomeTime + "__**").queue();
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            return;
        }

    }
}
