package me.cauadeveloper.commands.slash.individual.tabelaFunc;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class remover_func extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        if (command.equals("Remover_funcionario")){
            String userTag = event.getUser().getAsTag();
            event.reply("Remover funcionario no servidor, **" + userTag + "**!").queue();
        }
    }

}
