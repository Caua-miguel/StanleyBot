package me.cauadeveloper.comandos.admin.funcionario;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static me.cauadeveloper.sqlite.remover.RemoverFunc.removerFunc;
import static me.cauadeveloper.sqlite.inserir.NovoFunc.insert_novo_func;
import static me.cauadeveloper.sqlite.consulta.tabelas.ListarFunc.*;
import static me.cauadeveloper.sqlite.atualizar.AtualizarFunc.updateFuncionario;

public class AdicionarAtualizarRemoverFunc extends ListenerAdapter {

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
        OptionMapping idDiscOption = event.getOption("id_disc");
        OptionMapping nomeFuncOption = event.getOption("nome_func");
        OptionMapping nomeTimeOption = event.getOption("nome_time");
        Member member = event.getMember();

        if (member == null) {
            event.reply("Não foi possível identificar o membro.").setEphemeral(true).queue();
            return;
        }

        if (!member.hasPermission(Permission.ADMINISTRATOR)){
            event.reply("Você não tem permissão para usar esse comando!").setEphemeral(true).queue();
            return;
        }

        switch (command) {
            // Vai precisar criar um parâmetro para o usuário do discord
            case "adicionar_funcionario":
                String nomeFunc = nomeFuncOption.getAsString();
                String idDisc = idDiscOption.getAsString();
                String nomeTime = nomeTimeOption.getAsString();
                try {
                    insert_novo_func(idDisc, nomeFunc, nomeTime);
                    event.reply("Você adicionou o funcionário **" + nomeFunc + "!**\nEle está no time **" + nomeTime + "!**").setEphemeral(true).queue();
                } catch (SQLException e) {
                    System.out.println("Erro no insert_novo_func do case adicionar_funcionario.\nErro: " + e);
                    event.reply("Não encontrei nenhum time com esse nome! Por favor insira o nome do time corretamente para que seu funcionário possa ser atribuído a algum.").setEphemeral(true).queue();
                }
                break;
            case "atualizar_funcionario":

                try {
                    ArrayList<String> listaNomeFunc = selectNomeFunc();
                    ArrayList<String> listaIdFunc = selectIdFunc();

                    event.reply("Escolha um usuário da lista para atualizar, use os identificadores numéricos:").setEphemeral(true).queue();

                    for (int i = 0; i < listaIdFunc.size(); i++){
                        event.getChannel().sendMessage("\n" + listaIdFunc.get(i) + " - " + listaNomeFunc.get(i)).queue();
                    }

                    conversationAtualizaFunc.put(event.getUser(), new ConversationstateAtualizaFuncAtualizaFunc());

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "remover_funcionario":
                // Mudar a lista para um StringBuilder
                try {
                    ArrayList<String> listaNomeFunc = selectNomeFunc();
                    ArrayList<String> listaIdFunc = selectIdFunc();

                    event.reply("Escolha um usuário da lista para deletar, **use o id do discord para escolher**:").setEphemeral(true).queue();

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
                        String relacao_nomeFunc_idFunc = selectUmNomeFunc(stateAtualizaFunc.idFuncSessaoAtualizaFunc);

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
                    String relacao_nomeFunc_idFunc = selectUmNomeFunc(stateDeletaFunc.idFuncSessaoDeletaFunc);
                    removerFunc(stateDeletaFunc.idFuncSessaoDeletaFunc);
                    event.getChannel().sendMessage("O funcionário **" + relacao_nomeFunc_idFunc + "** foi removido com sucesso!").queue();
                    conversationDeletaFunc.remove(user);
                } catch (SQLException e) {
                    event.getChannel().sendMessage("Por favor, use os identificadores numéricos para selecionar um usuário!.").queue();
                } catch (RuntimeException e){
                    event.getChannel().sendMessage("Usuário não encontrado! Por favor, selecione um usuário válido!").queue();
                }
            }

        }

    }
}
