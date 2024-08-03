package me.cauadeveloper.commands.group.individual;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class atualizarDadosMembroTime extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        if (command.equals("atualizarMembro")){
            String userTag = event.getUser().getAsTag();
            event.reply("Welcome to the server, **" + userTag + "**!").queue();
        }
    }

    //Guild command -- instantly update (max 100)

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event){

        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("atualizarMembro", "Get welcomed by the bot."));
        event.getGuild().updateCommands().addCommands(commandData).queue();

//        if (event.getGuild().getIdLong() == id do servidor){} -- server para fazer commando especifico para o servidor

    }

}
