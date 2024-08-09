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
import static me.cauadeveloper.database.query.collumn_names.allNamesFunc.selectNomeFunc;
import static me.cauadeveloper.database.update.funcionario.updateFuncionario;

public class add_atualiza_remove_func extends ListenerAdapter {

    int id = -1;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        OptionMapping nomeFuncOption = event.getOption("nome_func");
        OptionMapping nomeTimeOption = event.getOption("nome_time");
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
                // Pensar em uma forma de o usuário atualizar o funcionario caso ele erre algo.
            case "atualizar_funcionario":

                try {

                    SetMenu setMenu = new SetMenu();
                    StringSelectMenu menu_atualiza_funcionario = setMenu.menuNomesFunc();

                    event.reply("Selecione um funcionario:")
                            .addActionRow(menu_atualiza_funcionario)
                            .setEphemeral(true)
                            .queue();

                    updateFuncionario(id, nomeFunc, nomeTime);
                    event.reply("Você atualizou o funcionário **" + nomeFunc + "**!").queue();
                } catch (SQLException e) {
                    System.out.println("Erro no insert_novo_func do case atualizar_funcionario.\nErro: " + e);
                    event.reply("Não encontrei nenhum time com esse nome! Por favor insira o nome do time corretamente para que seu funcionário possa ser atribuído a algum.").queue();
                }
                break;
            case "remover_funcionario":
                event.reply("Você removeu o funcionário **" + nomeFunc + "**!").queue();
                break;
            default:
                event.reply("Adicione o nome do seu funcionário, por favor!").queue();
        }
    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {

        String selectValue = event.getValues().get(0);
        try {
            ArrayList<String> nomeFunc = selectNomeFunc();

            for (int i = 0; i < nomeFunc.size(); i++){
                if (selectValue.equalsIgnoreCase(nomeFunc.get(i))){

                    id = i;

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
