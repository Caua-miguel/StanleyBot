package me.cauadeveloper.commands.group.individual.atualizar;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class removerMembroTime extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        if (command.equals("Remover_funcionario")){
            String userTag = event.getUser().getAsTag();
            event.reply("Remover funcionario no servidor, **" + userTag + "**!").queue();
        }
    }

    //Guild command -- instantly update (max 100)

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event){

        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("remover_funcionario", "Remove um funcionario."));
        event.getGuild().updateCommands().addCommands(commandData).queue();

//        if (event.getGuild().getIdLong() == id do servidor){} -- server para fazer commando especifico para o servidor

    }

}
