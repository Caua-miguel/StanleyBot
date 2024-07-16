package me.cauadeveloper.commands.general;

import me.cauadeveloper.database.tables.table_funcionario;
import me.cauadeveloper.utils.constructs.twoTypesArr;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.SQLException;

import static me.cauadeveloper.database.dataconfig.readConfig.dataUserCollumnA;
import static me.cauadeveloper.database.tables.table_funcionario.insert_data_user_func;
import static me.cauadeveloper.utils.files.inputUser.readFileUserCollumnA;

public class pathDB extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();
        Message.Attachment attachment = event.getMessage().getAttachments().getFirst();




        if(content.startsWith("!path")) {
            if(!message.getAttachments().isEmpty()){

                try {
                    insert_data_user_func(dataUserCollumnA(readFileUserCollumnA(attachment)));
                    channel.sendMessage("Arquivo receebido com sucesso!").queue();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else{
                channel.sendMessage("Por favor, mande em anexo o arquivo solicitado junto com a mensagem <!path>");
            }


            }


        }
    }
