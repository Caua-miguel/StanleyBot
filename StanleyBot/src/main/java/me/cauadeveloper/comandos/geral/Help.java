package me.cauadeveloper.comandos.geral;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Help extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping opHelp = event.getOption("help_argumento");
        EmbedBuilder embed = new EmbedBuilder();
        EmbedBuilder embedAdm = new EmbedBuilder();
        EmbedBuilder embedUser = new EmbedBuilder();

        if (command.equalsIgnoreCase("help")){

            // Sem argumento
                embed.setTitle("Help");
                embed.setDescription("O StanleyBot é seu auxiliar na preparação do seu café.\n\n" +
                        "Os comandos que temos são separados para o administrador e para o usuário padrão. Use o comando `/help adm` para visualizar o que o administrador pode fazer ou" +
                                     " use o comando `/help usuario` para ver os comandos que todos podem usar.");

            // Admin

                embedAdm.setTitle("Help");
                embedAdm.setDescription("Os comandos que o administrador pode usar são: \n\n" +
                        "1 - /iniciar \n\n 2 - /inserir dados iniciais \n\n 3 - /criar cargo \n\n 4 - /adicionar* \n\n 5 - /atualizar* \n\n 6 - /remover* \n\n 7 - /escolher time da semana");

            // Usuario

                embedUser.setTitle("Help");
                embedUser.setDescription("Os comandos que todos podem usar são:\n\n" +
                        "1 - /listar* \n\n 2 - /cronometro \n\n 3 - /help \n\n 4 - /ping \n\n 5 - reportar falta \n\n 6 - /time da semana");

                try {

                    String cargo = opHelp.getAsString();

                    switch (cargo){

                        case "adm":

                            event.replyEmbeds(embedAdm.build()).setEphemeral(true).queue();

                        break;

                        case "usuario":

                            event.replyEmbeds(embedUser.build()).setEphemeral(true).queue();

                        break;

                    }

                }catch (NullPointerException e){
                    event.replyEmbeds(embed.build()).setEphemeral(true).queue();
                }






        }

    }
}
