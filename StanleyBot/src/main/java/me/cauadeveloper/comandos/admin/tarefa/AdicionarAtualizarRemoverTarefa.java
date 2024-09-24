package me.cauadeveloper.comandos.admin.tarefa;

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

import static me.cauadeveloper.sqlite.atualizar.AtualizaTarefa.updateTarefa;
import static me.cauadeveloper.sqlite.consulta.tabelas.ListaTarefas.*;
import static me.cauadeveloper.sqlite.inserir.NovaTarefa.insertNovaTarefa;
import static me.cauadeveloper.sqlite.remover.RemoverTarefa.removerTarefa;

public class AdicionarAtualizarRemoverTarefa extends ListenerAdapter {


    private final Map<User, ConversationstateAtualizaTarefa> conversationAtualizaTarefa = new HashMap<>();
    private final Map<User, ConversationDeletaTarefa> conversationDeletaTarefa = new HashMap<>();

    private static class ConversationstateAtualizaTarefa{
        int stepAtualizaTime = 0;
        String nomeTimeSessaoAtualizaTime;
        String novoNomeTimeSessaoAtualizaTime;
    }

    private static class ConversationDeletaTarefa{
        int stepDeletaTime = 0;
        String nomeTimeSessaoDeletaTime;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        OptionMapping nomeTarefaOption = event.getOption("desc_tarefa");
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
            case "adicionar_tarefa":
                String descTarefa = nomeTarefaOption.getAsString();
                try {

                    insertNovaTarefa(descTarefa);
                    event.reply("Você adicionou uma nova tarefa!\n").setEphemeral(true).queue();

                } catch (SQLException e) {
                    System.out.println("Erro no insertNovaTarefa.\nErro: " + e);
                }
                break;
            case "atualizar_tarefa":

                try {
                    ArrayList<String> listaIdTarefas = selectIdTarefa();
                    ArrayList<String> listaDescTarefas = selectListaTarefas();
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < listaDescTarefas.size(); i++){
                        stringBuilder.append((listaIdTarefas.get(i)) + " - " + listaDescTarefas.get(i));
                        if (i < listaDescTarefas.size()-1){
                            stringBuilder.append("\n");
                        }
                    }

                    event.reply("Escolha uma tarefa da lista para atualizar (use os identificadores numéricos):\n" + stringBuilder).setEphemeral(true).queue();

                    conversationAtualizaTarefa.put(event.getUser(), new ConversationstateAtualizaTarefa());

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remover_tarefa":
                try {
                    ArrayList<String> listaIdTarefas = selectIdTarefa();
                    ArrayList<String> listaDescTarefas = selectListaTarefas();
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < listaDescTarefas.size(); i++){
                        stringBuilder.append((listaIdTarefas.get(i)) + " - " + listaDescTarefas.get(i));
                        if (i < listaDescTarefas.size()-1){
                            stringBuilder.append("\n");
                        }
                    }
                    event.reply("Escolha uma tarefa da lista para deletar:\n" + stringBuilder).setEphemeral(true).queue();

                    conversationDeletaTarefa.put(event.getUser(), new ConversationDeletaTarefa());

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
        ConversationstateAtualizaTarefa stateAtualizaTarefa = conversationAtualizaTarefa.get(user);

        if (stateAtualizaTarefa != null) {

            switch (stateAtualizaTarefa.stepAtualizaTime) {

                case 0:
                    try {
                        stateAtualizaTarefa.nomeTimeSessaoAtualizaTime = event.getMessage().getContentRaw();
                        String nomeTarefa = selectUmaDescTarefas(Integer.parseInt(stateAtualizaTarefa.nomeTimeSessaoAtualizaTime));

                        stateAtualizaTarefa.stepAtualizaTime = 1;
                        event.getChannel().sendMessage("Por favor, escreva uma nova descrição!\nDescrição atual: " + nomeTarefa).queue();

                    } catch (SQLException e) {
                        throw new RuntimeException();
                    } catch (NumberFormatException e) {
                        event.getChannel().sendMessage("Por favor, use os identificadores numéricos para selecionar um usuário!").queue();
                    } catch (RuntimeException e){
                        event.getChannel().sendMessage("Não tem um time com esse identificador!!!").queue();
                    }
                    break;

                case 1:

                    try {
                        stateAtualizaTarefa.novoNomeTimeSessaoAtualizaTime = event.getMessage().getContentRaw();

                        updateTarefa(Integer.parseInt(stateAtualizaTarefa.nomeTimeSessaoAtualizaTime), stateAtualizaTarefa.novoNomeTimeSessaoAtualizaTime);
                        event.getChannel().sendMessage("Tarefa atualziada com sucesso!").queue();

                    } catch (NumberFormatException e) {
                        event.getChannel().sendMessage("Por favor, use os identificadores numéricos para selecionar um usuário!").queue();
                    } catch (SQLException e){
                        System.out.println("Erro no update do nome time\n Erro: " + e.getMessage());
                    }
                    break;
            }
            return;
        }

        ConversationDeletaTarefa stateDeletaFunc = conversationDeletaTarefa.get(user);

        if (stateDeletaFunc != null) {

            if (stateDeletaFunc.stepDeletaTime == 0) {
                stateDeletaFunc.nomeTimeSessaoDeletaTime = event.getMessage().getContentRaw();
                String tarefa = stateDeletaFunc.nomeTimeSessaoDeletaTime;
                try {
                    removerTarefa(tarefa);
                    event.getChannel().sendMessage("A tarefa foi removida com sucesso!").queue();
                    conversationDeletaTarefa.remove(user);
                } catch (SQLException e) {
                    event.getChannel().sendMessage("Por favor, use os identificadores numéricos para selecionar um time!.").queue();
                } catch (RuntimeException e){
                    event.getChannel().sendMessage("Time não encontrado! Por favor, selecione um time válido!").queue();
                }
            }

        }

    }


}
