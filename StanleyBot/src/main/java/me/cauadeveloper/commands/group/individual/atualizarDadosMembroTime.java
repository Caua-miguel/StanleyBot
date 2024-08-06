package me.cauadeveloper.commands.group.individual;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static me.cauadeveloper.database.query.collumn_names.allNamesFunc.selectNomeFunc;
import static me.cauadeveloper.database.query.collumn_names.allNamesTeam.selectNomeTime;

public class atualizarDadosMembroTime extends ListenerAdapter{

    ArrayList<String> nomeTime;
    ArrayList<String> nomeFunc;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();

        try {
            nomeTime = selectNomeTime();
            List<SelectOption> optionsNomeTime = new ArrayList<>();
            for (int i = 0; i < nomeTime.size(); i++){
                optionsNomeTime.add(SelectOption.of(nomeTime.get(i), nomeTime.get(i)));
            }

            if (command.equals("adicionar_func_ao_time")){

                StringSelectMenu menu_time = StringSelectMenu.create("menu_time")
                        .setPlaceholder("Escolha uma opção...")
                        .addOptions(
                            optionsNomeTime
                        )
                        .build();

                event.reply("Escolha uma opção do menu suspenso:")
                        .addActionRow(menu_time)
                        .queue();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {

        String selectValue = event.getValues().get(0);
        try {
            nomeFunc = selectNomeFunc();
            List<SelectOption> optionsNomeFunc = new ArrayList<>();
            for (int i = 0; i < nomeFunc.size(); i++){
                optionsNomeFunc.add(SelectOption.of(nomeFunc.get(i), nomeFunc.get(i)));
            }

            for (int i = 0; i < nomeTime.size(); i++){
                if (selectValue.equalsIgnoreCase(nomeTime.get(i))){
                    StringSelectMenu menu_funcionario = StringSelectMenu.create("menu_funcionario")
                            .setPlaceholder("Escolha uma opção...")
                            .addOptions(
                                    optionsNomeFunc
                            )
                            .build();

                    event.reply("Adicione um funcionario ao time " + nomeTime.get(i) + ":")
                            .addActionRow(menu_funcionario)
                            .queue();
                }
            }
            for (int i = 0; i < nomeFunc.size(); i++){
                if (selectValue.equalsIgnoreCase(nomeFunc.get(i))){
                    event.reply("Você adicionou o funcionário **" + nomeFunc.get(i) + "**.").queue();
                }
            }

            event.getMessage().delete().queue();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event){

        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("adicionar_func_ao_time", "Adiciona um funcionário ao time selecionado."));
        event.getGuild().updateCommands().addCommands(commandData).queue();

//        if (event.getGuild().getIdLong() == id do servidor){} -- server para fazer commando especifico para o servidor


    }

}
