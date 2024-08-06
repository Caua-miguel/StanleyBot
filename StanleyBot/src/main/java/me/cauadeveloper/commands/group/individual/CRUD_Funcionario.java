package me.cauadeveloper.commands.group.individual;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CRUD_Funcionario extends ListenerAdapter {

    // Vai ser um slash command - o usuário tem que conseguir escolher os nomes dos funcionários que foram adicionados na tabela inicial
    // e os funcionários que ele escoleher vai ajustar o idTime da tabela funcionário de acordo com o id dos times.

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();

        switch (command){

            case "adicionar_funcionario":
                String addFunc = event.getUser().getAsTag();
                event.reply("Adicionar funcionario no servidor, **" + addFunc + "**!").queue();
                break;
            case "atualizar_funcionario":
                String updateFunc = event.getUser().getAsTag();
                event.reply("Atualiza funcionario no servidor, **" + updateFunc + "**!").queue();
                break;
            case "remover_funcionario":
                String removerFunc = event.getUser().getAsTag();
                event.reply("Remover funcionario no servidor, **" + removerFunc + "**!").queue();
        }
    }

    //Guild command -- instantly update (max 100)

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event){

        // Vou precisar adicionar uma lista com os nomes dos funcionário para criar várias opções no comando.
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("adicionar_funcionario", "Adiciona um novo funcionario a tabela funcionario."));
        commandData.add(Commands.slash("atualizar_funcionario", "Atualiza os dados de um funcionario"));
        commandData.add(Commands.slash("remover_funcionario", "Remove um funcionario"));
        event.getGuild().updateCommands().addCommands(commandData).queue();

//        if (event.getGuild().getIdLong() == id do servidor){} -- server para fazer commando especifico para o servidor

    }

}
