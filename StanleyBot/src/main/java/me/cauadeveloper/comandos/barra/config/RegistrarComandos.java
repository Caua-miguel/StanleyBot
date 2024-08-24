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

            // Parâmetros
            OptionData opNomeFunc = new OptionData(OptionType.STRING, "nome_func", "Nome do funcionário", true);
            OptionData opNomeTime = new OptionData(OptionType.STRING, "nome_time", "Nome do time", true);

            OptionData opNomeCargo = new OptionData(OptionType.STRING, "nome_cargo", "Nome do cargo", true);
            OptionData opNomeCargoCopia = new OptionData(OptionType.STRING, "nome_cargo_copia", "Nome do cargo copiado", true);

            OptionData opCronometro = new OptionData(OptionType.INTEGER, "tempo_em_minutos", "Tempo em minutos", false);
            OptionData opIniciar = new OptionData(OptionType.ATTACHMENT, "dados_iniciais", "Arquivo com os dados dos times", true);

            OptionData opReportarFalta = new OptionData(OptionType.STRING, "item_faltante", "Item em falta", true);

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


            //Time
            commandData.add(Commands.slash("escolher_time_da_semana", "Decide qual time da semana vai ficar responsável pelo café."));


            //Tarefa



            // Geral
            commandData.add(Commands.slash("cronometro", "Vai gerar um aviso quando o tempo acabar.").addOptions(opCronometro));
            commandData.add(Commands.slash("ping", "Exibe o ping do bot."));
            commandData.add(Commands.slash("time_da_semana", "Mostra qual time é responsável pelo café essa semana."));
            commandData.add(Commands.slash("listar_tarefas", "Exibe um lista de tarefas."));
            commandData.add(Commands.slash("reportar_falta", "Avisa quando faltar algum item.").addOptions(opReportarFalta));



            event.getGuild().updateCommands().addCommands(commandData).queue();

    }

}
