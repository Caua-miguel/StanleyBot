package me.cauadeveloper.comandos.barra.admin.geral;

import me.cauadeveloper.sqlite.tabelas.TabelaFunc;
import me.cauadeveloper.sqlite.tabelas.TabelaTarefa;
import me.cauadeveloper.sqlite.tabelas.TabelaTime;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import static me.cauadeveloper.sqlite.consulta.geral.VerificarTabelaVazia.check_if_tableFunc_is_null;
import static me.cauadeveloper.utils.arquivos.tabelas_iniciais.LerDadosUsuario.*;

public class InserirDadosIniciais extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping optionMapping = event.getOption("dados_iniciais");
        Member member = event.getMember();

        if (member == null) {
            event.reply("Não foi possível identificar o membro.").setEphemeral(true).queue();
            return;
        }

        if (!member.hasPermission(Permission.ADMINISTRATOR)){
            event.reply("Você não tem permissão para usar esse comando!").setEphemeral(true).queue();
            return;
        }

        if (command.equalsIgnoreCase("inserir_dados_iniciais")){

            Message.Attachment arquivoRetornado = optionMapping.getAsAttachment();

            try {
                    // Vou precisar resolver o problema de o usuário preencher de maneira errada as tabelas e precisar refazer.
                    if (check_if_tableFunc_is_null() == 0) {
                        TabelaFunc.insert_data_user_func(readFileUserCollumnA(arquivoRetornado));
                        TabelaTarefa.insert_data_user_tarefa(readFileUserCollumnI(arquivoRetornado));
                        TabelaTime.insert_data_user_time(readFileUserCollumnE(arquivoRetornado));
                        event.reply("O arquivo foi recebido com sucesso").setEphemeral(true).queue();
                    } else {
                        event.reply("A sua tabela já foi preenchida com os dados iniciais. Caso queira adicionar dados, você" +
                                " precisa usar o slash command `/adicionar_func_ao_time`").setEphemeral(true).queue();
                    }
                // PRECISO DE UM RETORNO DE ERRO CASO A TABELA ESTEJA VAZIA

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                event.reply("Arquivo não reconhecido, me passe o arquivo **grupos.xls**").setEphemeral(true).queue();
            }


        }




    }
}
