package me.cauadeveloper.commands.general;

import me.cauadeveloper.database.tables.table_funcionario;
import me.cauadeveloper.database.tables.table_tarefa;
import me.cauadeveloper.database.tables.table_time;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import static me.cauadeveloper.database.dataconfig.readConfig.*;
import static me.cauadeveloper.utils.files.inputUser.*;

public class pathDB extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String[] command = event.getMessage().getContentRaw().split(" ", 2);

            if (command[0].equalsIgnoreCase("!path")) {
                if (command.length < 2) {
                    channel.sendMessage("Por favor, forneça o caminho do arquivo.").queue();
                } else {
                    try {
                        // Fazer para todas as colunas que faltam;
                        table_funcionario.insert_data_user_func(dataUserCollumnA(readFileUserCollumnA(command[1])));
                        table_tarefa.insert_data_user_tarefa(dataUserCollumnI(readFileUserCollumnI(command[1])));
                        table_time.insert_data_user_time(dataUserCollumnE(readFileUserCollumnE(command[1])));
                        channel.sendMessage("O arquivo foi recebido com sucesso").queue();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
