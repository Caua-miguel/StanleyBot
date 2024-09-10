package me.cauadeveloper.comandos.admin.funcionario.relacao_func_time;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListaTimes.selectAllNomeTime;
import static me.cauadeveloper.sqlite.consulta.tabelas.ListaFunc.selectNomeFunc;
import static me.cauadeveloper.sqlite.consulta.relacao_tabelas.RelacaoFuncTime.insert_idTime_in_func;

public class AdicionarFuncAoTime extends ListenerAdapter{

    ArrayList<String> nomeTime;
    ArrayList<String> nomeFunc;
    private String armazenaNomeTime;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        Member member = event.getMember();

        try {
            nomeTime = selectAllNomeTime();
            List<SelectOption> optionsNomeTime = new ArrayList<>();
            for (int i = 0; i < nomeTime.size(); i++){
                optionsNomeTime.add(SelectOption.of(nomeTime.get(i), nomeTime.get(i)));
            }

            if (member == null) {
                event.reply("Não foi possível identificar o membro.").setEphemeral(true).queue();
                return;
            }

            if (!member.hasPermission(Permission.ADMINISTRATOR)){
                event.reply("Você não tem permissão para usar esse comando!").setEphemeral(true).queue();
                return;
            }

            if (command.equals("adicionar_func_ao_time")){

                StringSelectMenu menu_time = StringSelectMenu.create("menu_time")
                        .setPlaceholder("Escolha uma opção...")
                        .addOptions(
                                optionsNomeTime
                        )
                        .build();

                event.reply("Escolha uma opção do menu suspenso:")
                        .addActionRow(menu_time)
                        .queue();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {

        String selectValue = event.getValues().get(0);
        try {

            nomeFunc = selectNomeFunc();
            List<SelectOption> optionsNomeFunc = new ArrayList<>();

            for (int cont = 0; cont < nomeFunc.size(); cont++){
                optionsNomeFunc.add(SelectOption.of(nomeFunc.get(cont), nomeFunc.get(cont)));
            }

            for (int i = 0; i < nomeTime.size(); i++){
                if (selectValue.equalsIgnoreCase(nomeTime.get(i))) {
                    StringSelectMenu menu_funcionario = StringSelectMenu.create("menu_funcionario")
                            .setPlaceholder("Escolha uma opção...")
                            .addOptions(
                                    optionsNomeFunc
                            )
                            .build();

                    event.reply("Adicione um funcionario ao time " + nomeTime.get(i) + ":")
                            .addActionRow(menu_funcionario)
                            .setEphemeral(true)
                            .queue();
                    armazenaNomeTime = nomeTime.get(i);
                }

            }

            for (int j = 0; j < nomeFunc.size(); j++){

                if (selectValue.equalsIgnoreCase(nomeFunc.get(j))) {
                    insert_idTime_in_func(armazenaNomeTime, nomeFunc.get(j));
                    event.reply("Você adicionou o funcionário **" + nomeFunc.get(j) + "** ao time **" + armazenaNomeTime + "**.")
                            .setEphemeral(true)
                            .queue();
                }

            }

            event.getMessage().delete().queue();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e){
            System.out.println("O comando adicionar_func_ao_time está sem parametro!");
        }
    }

}