package me.cauadeveloper.comandos.admin.time;

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

import static me.cauadeveloper.sqlite.atualizar.AtualizarTime.updateTime;
import static me.cauadeveloper.sqlite.consulta.tabelas.ListaTimes.*;
import static me.cauadeveloper.sqlite.inserir.NovoTime.insertNovoTime;
import static me.cauadeveloper.sqlite.remover.RemoverTime.removerTime;

public class AdicionarAtualizarRemoverTime extends ListenerAdapter {

    private final Map<User, ConversationstateAtualizaTime> conversationAtualizaTime = new HashMap<>();
    private final Map<User, ConversationstateDeletaTime> conversationDeletaTime = new HashMap<>();

    private static class ConversationstateAtualizaTime{
        int stepAtualizaTime = 0;
        String nomeTimeSessaoAtualizaTime;
        String novoNomeTimeSessaoAtualizaTime;
    }

    private static class ConversationstateDeletaTime{
        int stepDeletaTime = 0;
        String nomeTimeSessaoDeletaTime;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
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
            case "adicionar_time":
                String nomeTime = nomeTimeOption.getAsString();
                try {

                    insertNovoTime(nomeTime);
                    event.reply("Você adicionou o time **" + nomeTime + "**\n").setEphemeral(true).queue();

                } catch (SQLException e) {
                    System.out.println("Erro no insertNovoTime - adicionar_time.\nErro: " + e);
                }
                break;
            case "atualizar_time":

                try {
                    ArrayList<String> listaIdTimes = selectIdTime();
                    ArrayList<String> listaNomeTimes = selectAllNomeTime();
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < listaNomeTimes.size(); i++){
                        stringBuilder.append((listaIdTimes.get(i)) + " - " + listaNomeTimes.get(i));
                        if (i < listaNomeTimes.size()-1){
                            stringBuilder.append("\n");
                        }
                    }

                    event.reply("Escolha um time da lista para atualizar (use os identificadores numericos):\n" + stringBuilder.toString()).setEphemeral(true).queue();

                    conversationAtualizaTime.put(event.getUser(), new ConversationstateAtualizaTime());

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remover_time":
                try {
                    ArrayList<String> listaIdTimes = selectIdTime();
                    ArrayList<String> listaNomeTimes = selectAllNomeTime();
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < listaNomeTimes.size(); i++){
                        stringBuilder.append((listaIdTimes.get(i)) + " - " + listaNomeTimes.get(i));
                        if (i < listaNomeTimes.size()-1){
                            stringBuilder.append("\n");
                        }
                    }
                    event.reply("Escolha um time da lista para deletar:\n" + stringBuilder.toString()).setEphemeral(true).queue();

                    conversationDeletaTime.put(event.getUser(), new ConversationstateDeletaTime());

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
        ConversationstateAtualizaTime stateAtualizaFunc = conversationAtualizaTime.get(user);

        if (stateAtualizaFunc != null) {

            switch (stateAtualizaFunc.stepAtualizaTime) {

                case 0:
                    try {
                        stateAtualizaFunc.nomeTimeSessaoAtualizaTime = event.getMessage().getContentRaw();
                        String nomeTime = selectNomeTime(Integer.valueOf(stateAtualizaFunc.nomeTimeSessaoAtualizaTime));

                        stateAtualizaFunc.stepAtualizaTime = 1;
                        event.getChannel().sendMessage("Por favor, escreva um novo nome para o time **" + nomeTime + "**, para que ele seja atualizado!").queue();

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
                        stateAtualizaFunc.novoNomeTimeSessaoAtualizaTime = event.getMessage().getContentRaw();

                        updateTime(Integer.valueOf(stateAtualizaFunc.nomeTimeSessaoAtualizaTime), stateAtualizaFunc.novoNomeTimeSessaoAtualizaTime);
                        event.getChannel().sendMessage("Time atualziado com sucesso!").queue();

                    } catch (NumberFormatException e) {
                        event.getChannel().sendMessage("Por favor, use os identificadores numéricos para selecionar um usuário!").queue();
                    } catch (SQLException e){
                        System.out.println("Erro no update do nome time\n Erro: " + e.getMessage());
                    }
                    break;
            }
            return;
        }

        ConversationstateDeletaTime stateDeletaFunc = conversationDeletaTime.get(user);

        if (stateDeletaFunc != null) {

            if (stateDeletaFunc.stepDeletaTime == 0) {
                stateDeletaFunc.nomeTimeSessaoDeletaTime = event.getMessage().getContentRaw();
                String time = stateDeletaFunc.nomeTimeSessaoDeletaTime;
                try {
                    removerTime(time);
                    event.getChannel().sendMessage("O time **" + time + "** foi removido com sucesso!").queue();
                    conversationDeletaTime.remove(user);
                } catch (SQLException e) {
                    event.getChannel().sendMessage("Por favor, use os identificadores numéricos para selecionar um time!.").queue();
                } catch (RuntimeException e){
                    event.getChannel().sendMessage("Time não encontrado! Por favor, selecione um time válido!").queue();
                }
            }

        }

    }
}
