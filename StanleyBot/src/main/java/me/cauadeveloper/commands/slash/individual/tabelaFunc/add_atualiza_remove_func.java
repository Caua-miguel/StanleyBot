package me.cauadeveloper.commands.slash.individual.tabelaFunc;

import me.cauadeveloper.commands.slash.config.SetMenu;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static me.cauadeveloper.database.insert.novo_funcionario.insert_novo_func;
import static me.cauadeveloper.database.query.collumn_names.allNamesFunc.selectIdFunc;
import static me.cauadeveloper.database.query.collumn_names.allNamesFunc.selectNomeFunc;
import static me.cauadeveloper.database.update.funcionario.updateFuncionario;

public class add_atualiza_remove_func extends ListenerAdapter {

    int id = -1;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        OptionMapping idFuncOption = event.getOption("id_func");
        OptionMapping nomeFuncOption = event.getOption("nome_func");
        OptionMapping nomeTimeOption = event.getOption("nome_time");
        String IDFunc = idFuncOption.getAsString();
        String nomeFunc = nomeFuncOption.getAsString();
        String nomeTime = nomeTimeOption.getAsString();

        switch (command) {
            case "adicionar_funcionario":
                try {
                    insert_novo_func(nomeFunc, nomeTime);
                    event.reply("Você adicionou o funcionário **" + nomeFunc + "!**\nEles estão no time **" + nomeTime + "!**").queue();
                } catch (SQLException e) {
                    System.out.println("Erro no insert_novo_func do case adicionar_funcionario.\nErro: " + e);
                    event.reply("Não encontrei nenhum time com esse nome! Por favor insira o nome do time corretamente para que seu funcionário possa ser atribuído a algum.").queue();
                }
                break;
                // Vou precisar usar o comando sem parâmetros, para retornar o menu. Depois vou precisar de dois comandos para selecionar o funcionário e outro para atualizar.
                // ERRO: Quando é digitado um numero maior que o que saiu no menu, ele não retorna um erro de SQL. Apenas não faz nada.
            case "atualizar_funcionario":

                try {
                    ArrayList<String> listaFunc = selectNomeFunc();
                    ArrayList<Integer> listaID = selectIdFunc();

                    event.getChannel().sendMessage("Selecione o numero que corresponde ao usuário e atualize-o:").queue();

                    for (int i = 0; i < listaFunc.size(); i++){
                        event.getChannel().sendMessage("\n" + listaID.get(i) + " - " + listaFunc.get(i)).queue();
                    }

                    updateFuncionario(Integer.parseInt(IDFunc),nomeFunc,nomeTime);

                } catch (SQLException e) {
                    event.reply("O index digitado não corresponde a um funcionário, digite um index válido de acordo com o menu apresentado!").queue();
                }catch (NumberFormatException e){
                    event.reply("O primerio parâmetro precisar ser um numero inteiro!").queue();
                }

                    event.reply("Você atualizou o funcionário **" + nomeFunc + "**!").queue();

                break;
            case "remover_funcionario":
                event.reply("Você removeu o funcionário **" + nomeFunc + "**!").queue();
                break;
            default:
                event.reply("Adicione o nome do seu funcionário, por favor!").queue();
        }
    }

}
