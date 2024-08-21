package me.cauadeveloper.comandos.barra.geral;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Cronometro extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping opCronometro = event.getOption("tempo_em_minutos");

        try {
            switch (command){

                case "cronometro":


                    int minutos = opCronometro.getAsInt();
                    String text = "Seu café estará pronto em " + minutos + " minutos...";

                    if(minutos <= 30 && minutos != 0){

                        event.reply(text).setEphemeral(true).queue(sentMessage -> {
                            sentMessage.editOriginal("Seu café está pronto!").queueAfter(minutos, MINUTES);
                        });

                    }else if(minutos == 0){

                        event.reply("Não estava esperando que você fosse tão rápido!!! Vou te avisar daqui 1 minuto...").setEphemeral(true).queue(
                                sentMessage -> {
                                    sentMessage.editOriginal("Seu café está pronto!").queueAfter(1, MINUTES);
                                }
                        );

                    }else{

                        event.reply("Mais de 30 minutos para fazer um café? Não precisa de tanto, eu confio em você!!!\nVocê tem 10 minutos!").setEphemeral(true).queue(
                                sentMessage -> {
                                    sentMessage.editOriginal("Seu café está pronto!").queueAfter(10, MINUTES);
                                });
                    }
                break;
            }
        }catch(NullPointerException e){

            event.reply("Seu café estará pronto em 10 minutos...").setEphemeral(true).queue(
                    sentMessage -> {
                        sentMessage.editOriginal("Seu café está pronto!").queueAfter(10, MINUTES);
                    });
        }
    }
}
