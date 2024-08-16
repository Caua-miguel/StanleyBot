package me.cauadeveloper.comandos.geral;

import me.cauadeveloper.sqlite.tabelas.TabelaFunc;
import me.cauadeveloper.sqlite.tabelas.TabelaTarefa;
import me.cauadeveloper.sqlite.tabelas.TabelaTime;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import static me.cauadeveloper.utils.arquivos.tabelas_iniciais.ConverterLista.*;
import static me.cauadeveloper.sqlite.consulta.geral.VerificarTabelaVazia.check_if_tableFunc_is_null;
import static me.cauadeveloper.utils.arquivos.tabelas_iniciais.LerDadosUsuario.*;

public class InserirDadosIniciais extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        MessageChannel channel = event.getChannel();
        String[] command = event.getMessage().getContentRaw().split(" ", 2);

            if (command[0].equalsIgnoreCase("!inserirDados")) {
                if (command.length < 2) {
                    channel.sendMessage("Por favor, forneça o caminho do arquivo.").queue();
                } else {
                    try {
                        // Vou precisar resolver o problema de o usuário preencher de maneira errada as tabelas e precisar refazer.
                        if(check_if_tableFunc_is_null() == 0){
                            TabelaFunc.insert_data_user_func(dataUserCollumnA(readFileUserCollumnA(command[1])));
                            TabelaTarefa.insert_data_user_tarefa(dataUserCollumnI(readFileUserCollumnI(command[1])));
                            TabelaTime.insert_data_user_time(dataUserCollumnE(readFileUserCollumnE(command[1])));
                            channel.sendMessage("O arquivo foi recebido com sucesso").queue();
                        }else{
                            channel.sendMessage("A sua tabela já foi preenchida com os dados iniciais. Caso queira adicionar dados, você" +
                                    " precisa usar o slash command **/adicionar_func_ao_time**").queue();
                        }
                    // PRECISO DE UM RETORNO DE ERRO CASO A TABELA ESTEJA VAZIA

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (FileNotFoundException e) {
                        event.getChannel().sendMessage("Arquivo não reconhecido, passe o caminho correto!").queue();
                    }
                }
            }
        }
    }
