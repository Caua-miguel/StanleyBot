package me.cauadeveloper.commands.general;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import static java.util.concurrent.TimeUnit.*;
public class timer extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] command = event.getMessage().getContentRaw().split(" ", 2);

        if(command[0].equalsIgnoreCase("!StartCoffe")) {
            if (command.length < 2){

                // Deixar a mensagem mais clara !!!
                event.getChannel().sendMessage("digite o parametro!!!").queue();

            }else{

                String text = "Seu café estará pronto em " + command[1] + " minutos...";

                event.getChannel().sendMessage(text).queue(sentMessage -> {
                    sentMessage.editMessage("Seu café está pronto!").queueAfter(Long.parseLong(command[1]), MINUTES);
                });
            }
        }
    }

}
