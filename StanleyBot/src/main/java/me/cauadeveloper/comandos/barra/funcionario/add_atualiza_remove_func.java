package me.cauadeveloper.comandos.barra.funcionario;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static me.cauadeveloper.sqlite.remover.removerFunc.removerFunc;
import static me.cauadeveloper.sqlite.inserir.novo_funcionario.insert_novo_func;
import static me.cauadeveloper.sqlite.consulta.tabelas.NamesFunc.*;
import static me.cauadeveloper.sqlite.atualizar.updateFunc.updateFuncionario;

public class add_atualiza_remove_func extends ListenerAdapter {

    private final Map<User, ConversationstateAtualizaFuncAtualizaFunc> conversationAtualizaFunc = new HashMap<>();
    private final Map<User, ConversationstateAtualizaFuncDeletaFunc> conversationDeletaFunc = new HashMap<>();

    private static class ConversationstateAtualizaFuncAtualizaFunc{
        int stepAtualizaFunc = 0;
        String idFuncSessaoAtualizaFunc, nomeFuncSessaoAtualizaFunc;
    }

    private static class ConversationstateAtualizaFuncDeletaFunc{
        int stepDeletaFunc = 0;
        String idFuncSessaoDeletaFunc;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        OptionMapping nomeFuncOption = event.getOption("nome_func");
        OptionMapping nomeTimeOption = event.getOption("nome_time");

        switch (command) {
            case "adicionar_funcionario":
                String nomeFunc = nomeFuncOption.getAsString();
                String nomeTime = nomeTimeOption.getAsString();
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
                    ArrayList<String> listaNomeFunc = selectNomeFunc();
                    ArrayList<Integer> listaIdFunc = selectIdFunc();

                    event.reply("Escolha um usuário da lista para atualizar, use os identificadores numéricos:").queue();

                    for (int i = 0; i < listaIdFunc.size(); i++){
                        event.getChannel().sendMessage("\n" + listaIdFunc.get(i) + " - " + listaNomeFunc.get(i)).queue();
                    }

                    conversationAtualizaFunc.put(event.getUser(), new ConversationstateAtualizaFuncAtualizaFunc());

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "remover_funcionario":

                try {
                    ArrayList<String> listaNomeFunc = selectNomeFunc();
                    ArrayList<Integer> listaIdFunc = selectIdFunc();

                    event.reply("Escolha um usuário da lista para deletar, use os identificadores numéricos:").queue();

                    for (int i = 0; i < listaIdFunc.size(); i++){
                        event.getChannel().sendMessage("\n" + listaIdFunc.get(i) + " - " + listaNomeFunc.get(i)).queue();
                    }

                    conversationDeletaFunc.put(event.getUser(), new ConversationstateAtualizaFuncDeletaFunc());

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) {
            return;
        }

        User user = event.getAuthor();
        ConversationstateAtualizaFuncAtualizaFunc stateAtualizaFunc = conversationAtualizaFunc.get(user);

        if (stateAtualizaFunc != null) {

            switch (stateAtualizaFunc.stepAtualizaFunc) {

                case 0:

                    stateAtualizaFunc.idFuncSessaoAtualizaFunc = event.getMessage().getContentRaw();

                    try {
                        String relacao_nomeFunc_idFunc = selectUmNomeFunc(Integer.parseInt(stateAtualizaFunc.idFuncSessaoAtualizaFunc));

                        stateAtualizaFunc.stepAtualizaFunc = 1;
                        event.getChannel().sendMessage("Por favor, escreva um novo nome para o funcionário **" + relacao_nomeFunc_idFunc + "**, para que ele seja atualizado!").queue();

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (NumberFormatException e) {
                        event.getChannel().sendMessage("Por favor, use os identificadores numéricos para selecionar um usuário!").queue();
                    }
                    break;
                case 1:
                    stateAtualizaFunc.nomeFuncSessaoAtualizaFunc = event.getMessage().getContentRaw();

                    try {
                        updateFuncionario(Integer.parseInt(stateAtualizaFunc.idFuncSessaoAtualizaFunc), stateAtualizaFunc.nomeFuncSessaoAtualizaFunc);
                        event.getChannel().sendMessage("Funcionário atualizado com sucesso!").queue();
                        conversationAtualizaFunc.remove(user);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
            return;
        }

        ConversationstateAtualizaFuncDeletaFunc stateDeletaFunc = conversationDeletaFunc.get(user);

        if (stateDeletaFunc != null) {

            if (stateDeletaFunc.stepDeletaFunc == 0) {
                stateDeletaFunc.idFuncSessaoDeletaFunc = event.getMessage().getContentRaw();
                try {
                    String relacao_nomeFunc_idFunc = selectUmNomeFunc(Integer.parseInt(stateDeletaFunc.idFuncSessaoDeletaFunc));
                    removerFunc(Integer.parseInt(stateDeletaFunc.idFuncSessaoDeletaFunc));
                    event.getChannel().sendMessage("O funcionário **" + relacao_nomeFunc_idFunc + "** foi removido com sucesso!").queue();
                    conversationDeletaFunc.remove(user);
                } catch (SQLException | NumberFormatException e) {
                    event.getChannel().sendMessage("Por favor, use os identificadores numéricos para selecionar um usuário!.").queue();
                } catch (RuntimeException e){
                    event.getChannel().sendMessage("Usuário não encontrado! Por favor, selecione um usuário válido!").queue();
                }
            }

        }

    }
}
