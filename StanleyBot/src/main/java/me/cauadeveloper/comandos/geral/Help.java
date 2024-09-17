package me.cauadeveloper.comandos.geral;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Help extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping optionMapping = event.getOption("help_argumento");
        EmbedBuilder embed = new EmbedBuilder();

        if (command.equalsIgnoreCase("help")){

                embed.setTitle("Help");
                embed.setDescription("O StanleyBot é seu auxiliar na preparação do seu café.\n\n" +
                        "Os comandos que temos são separados para o administrador e para o usuário padrão. Use o comando /help <adm> para visualizar o que o administrador pode fazer ou" +
                                     " use o comando /help <user> para ver os comandos que todos podem usar.");
            // Preciso dividir isso de uma forma que fique dinamico e mostre todos os comandos.

                    event.replyEmbeds(embed.build()).setEphemeral(true).queue();



        }

    }
}
