package me.cauadeveloper.comandos.barra.config;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RegistrarComandos extends ListenerAdapter {

        @Override
        public void onGuildReady(@NotNull GuildReadyEvent event){

            List<CommandData> commandData = new ArrayList<>();

            OptionData opNomeFunc = new OptionData(OptionType.STRING, "nome_func", "Nome do funcionário", true);
            OptionData opNomeTime = new OptionData(OptionType.STRING, "nome_time", "Nome do time", true);
            OptionData opNomeCargo = new OptionData(OptionType.STRING, "nome_cargo", "Nome do cargo", true);
            OptionData opNomeCargoCopia = new OptionData(OptionType.STRING, "nome_cargo_copia", "Nome do cargo copiado", true);

            // Cargos
            commandData.add(Commands.slash("criar_cargo_padrao", "Cria um cargo no servidor com as mesmas permissões de @everyone.").addOptions(opNomeCargo));
            commandData.add(Commands.slash("criar_cargo_vazio", "Cria um cargo no servidor sem nenhuma permissão.").addOptions(opNomeCargo));
            commandData.add(Commands.slash("criar_cargo_copia", "Cria um cargo no servidor com as mesmas permissões de um cargo existente.").addOptions(opNomeCargo).addOptions(opNomeCargoCopia));
            commandData.add(Commands.slash("listar_cargos", "Exibe uma lista dos cargos existentes no servidor."));



            // Funcionário
            commandData.add(Commands.slash("adicionar_func_ao_time", "Adiciona um funcionário ao time selecionado."));
            commandData.add(Commands.slash("adicionar_funcionario", "Adiciona um novo funcionario a tabela funcionario.").addOptions(opNomeFunc).addOptions(opNomeTime));
            commandData.add(Commands.slash("atualizar_funcionario", "Atualiza os dados de um funcionario"));
            commandData.add(Commands.slash("remover_funcionario", "Remove um funcionario"));
            event.getGuild().updateCommands().addCommands(commandData).queue();

    }

}
