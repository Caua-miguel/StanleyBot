package me.cauadeveloper.commands.general;

import me.cauadeveloper.utils.timer.Minuto;
import me.cauadeveloper.utils.timer.Segundo;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;
import static me.cauadeveloper.utils.fixValues.utilsStaticMethods.txtMin;
import static me.cauadeveloper.utils.fixValues.utilsStaticMethods.txtSeg;

public class timer extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();
        EmbedBuilder embed = new EmbedBuilder();
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Minuto minuto;
        Segundo segundo;
        Thread tMin, tSeg;


        if(content.equalsIgnoreCase("!StartCoffe")) {

            //Timer
            minuto = new Minuto();
            tMin = new Thread(minuto);

            segundo = new Segundo();
            tSeg = new Thread(segundo);


            String text = "Seu café estara pronto em 6 minutos...";


            Runnable timer = () -> channel.sendMessage(text).queue(sentMessage -> {
                sentMessage.editMessage("Seu café está pronto!").queueAfter(10, SECONDS);
            });

            ScheduledFuture timerHandle = scheduler.schedule(timer, 0, SECONDS);
            Runnable canceller = () -> timerHandle.cancel(false);
            scheduler.schedule(canceller, 30, SECONDS);

              //Mensagem
//            embed.setTitle("Cronometro");
//            embed.setDescription("Timer: " + txtMin + ":" + txtSeg);
//            channel.sendMessageEmbeds(embed.build()).queue();

        }
    }

}
