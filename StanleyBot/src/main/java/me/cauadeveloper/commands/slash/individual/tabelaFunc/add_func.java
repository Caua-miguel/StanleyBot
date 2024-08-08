package me.cauadeveloper.commands.slash.individual.tabelaFunc;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class add_func extends ListenerAdapter {

    // Vai ser um slash command - o usuário tem que conseguir escolher os nomes dos funcionários que foram adicionados na tabela inicial
    // e os funcionários que ele escoleher vai ajustar o idTime da tabela funcionário de acordo com o id dos times.

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        OptionMapping nomeOption = event.getOption("nome");
        String nomeFunc = nomeOption.getAsString();

        switch (command){

            case "adicionar_funcionario":

                event.reply("Você adicionou o funcionário **" + nomeFunc + "**!").queue();
                break;
            case "atualizar_funcionario":
                event.reply("Você atualizou o funcionário **" + nomeFunc + "**!").queue();
                break;
            case "remover_funcionario":
                event.reply("Você removeu o funcionário **" + nomeFunc + "**!").queue();
                break;
            default:
                event.reply("Adicione o nome do seu funcionário, porfavor!").queue();
        }

    }

}
