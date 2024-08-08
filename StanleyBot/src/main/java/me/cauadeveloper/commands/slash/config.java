package me.cauadeveloper.commands.slash;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class config extends ListenerAdapter {

        @Override
        public void onGuildReady(@NotNull GuildReadyEvent event){

            List<CommandData> commandData = new ArrayList<>();
            commandData.add(Commands.slash("adicionar_func_ao_time", "Adiciona um funcionário ao time selecionado."));

            OptionData opNameFunc = new OptionData(OptionType.STRING, "nome", "Nome do funcionário", true);
            commandData.add(Commands.slash("adicionar_funcionario", "Adiciona um novo funcionario a tabela funcionario.").addOptions(opNameFunc));
            commandData.add(Commands.slash("atualizar_funcionario", "Atualiza os dados de um funcionario").addOptions(opNameFunc));
            commandData.add(Commands.slash("remover_funcionario", "Remove um funcionario").addOptions(opNameFunc));
            event.getGuild().updateCommands().addCommands(commandData).queue();

    }

}
