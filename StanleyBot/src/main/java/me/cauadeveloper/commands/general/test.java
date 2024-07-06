package me.cauadeveloper.commands.general;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;

import static me.cauadeveloper.database.dataconfig.readConfig.*;
import static me.cauadeveloper.utils.files.inputUser.readFileUserCollumnA;

public class test extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();

        // O array tá acabando porque estou usando "null" e dividindo por virgula, ou seja, quando vai em um espaço vazio ele acaba
        if(content.equalsIgnoreCase(  "!test")) {

            ArrayList<String> list = readFileUserCollumnA();
            String dataList = String.valueOf(list);
            String[] arr1 = dataUserCollumnA();
            String data1 = Arrays.toString(arr1);

            String[] arr2 = dataUserCollumnE();
            String data2 = Arrays.toString(arr2);

            String[] arr3 = dataUserCollumnI();
            String data3 = Arrays.toString(arr3);

            channel.sendMessage(data1).queue();

        }
    }

}
