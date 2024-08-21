package me.cauadeveloper.comandos.geral;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import static java.util.concurrent.TimeUnit.*;
public class CronometroOb extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] command = event.getMessage().getContentRaw().split(" ", 2);


        try {

            if(command[0].equalsIgnoreCase("!StartCoffe")) {

                String text = "Seu café estará pronto em " + command[1] + " minutos...";
                int minutos = Integer.parseInt(command[1]);

                if(minutos <= 30 && minutos != 0){

                    event.getChannel().sendMessage(text).queue(sentMessage -> {
                        sentMessage.editMessage("Seu café está pronto!").queueAfter(Long.parseLong(command[1]), MINUTES);
                    });

                }else if(minutos == 0){
                    event.getChannel().sendMessage("Não estava esperando que você fosse tão rápido!!! Vou te avisar daqui 1 minuto...").queue(
                            sentMessage ->{
                                sentMessage.editMessage("Seu café está pronto!").queueAfter(1, MINUTES);
                            }
                    );
                }else{

                    event.getChannel().sendMessage("Mais de 30 minutos para fazer um café? Não precisa de tanto, eu confio em você!!!\nVocê tem 10 minutos!").queue(
                            sentMessage -> {
                                sentMessage.editMessage("Seu café está pronto!").queueAfter(10, MINUTES);
                            });

                }
            }

        }catch (NumberFormatException e){

            event.getChannel().sendMessage("Você precisa digitar um numero interino logo depois de rodar o comando <!startCoffe> <numero inteiro>." +
                    "\nExemplo: !startCoffe 2\n Para ser lembrado após 2 minutos. Rode o comando novamente, porfavor!").queue();

        }catch(ArrayIndexOutOfBoundsException e){

            event.getChannel().sendMessage("Seu café estará pronto em 10 minutos...").queue(sentMessage -> {
                sentMessage.editMessage("Seu café está pronto!").queueAfter(10, MINUTES);
            });
        }

    }

}
