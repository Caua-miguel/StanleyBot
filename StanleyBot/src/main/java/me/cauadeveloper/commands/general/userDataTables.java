package me.cauadeveloper.commands.general;

import me.cauadeveloper.database.tables.table_funcionario;
import me.cauadeveloper.database.tables.table_tarefa;
import me.cauadeveloper.database.tables.table_time;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;

import static me.cauadeveloper.database.dataconfig.readConfig.*;
import static me.cauadeveloper.database.query.general.checkTablesAreNull.check_if_tableFunc_is_null;
import static me.cauadeveloper.utils.files.initialDataBase.inputUser.*;

public class userDataTables extends ListenerAdapter {

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
                            table_funcionario.insert_data_user_func(dataUserCollumnA(readFileUserCollumnA(command[1])));
                            table_tarefa.insert_data_user_tarefa(dataUserCollumnI(readFileUserCollumnI(command[1])));
                            table_time.insert_data_user_time(dataUserCollumnE(readFileUserCollumnE(command[1])));
                            channel.sendMessage("O arquivo foi recebido com sucesso").queue();
                        }else{
                            channel.sendMessage("A sua tabela já foi preenchida com os dados iniciais. Caso queira adicionar dados, você" +
                                    " precisa usar o slash command **/adicionar_func_ao_time**").queue();
                        }
                    // PRECISO DE UM RETORNO DE ERRO CASO A TABELA ESTEJA VAZIA

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
