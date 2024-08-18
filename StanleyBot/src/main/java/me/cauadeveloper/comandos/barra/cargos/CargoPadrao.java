package me.cauadeveloper.comandos.barra.cargos;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class CargoPadrao extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        //Teste o Ephemeral e setar a permissão de admin
        // Verificar para não criar dois cargos com o mesmo nome
        String command = event.getName();
        OptionMapping nomeCargoOption = event.getOption("nome_cargo");

        if (event.isFromGuild() && command.equals("criar_cargo_padrao")){

            String nomeCargo = nomeCargoOption.getAsString();

            event.getGuild().createRole().setName(nomeCargo).queue();
            event.reply("O cargo `" + nomeCargo + "` foi criado com sucesso!").setEphemeral(true).queue();

        }

    }
}
