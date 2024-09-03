package me.cauadeveloper.comandos.geral.listas;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class ListarCagos extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        StringBuilder listaCargos = new StringBuilder();

        switch (command){

            case "listar_cargos":

                List<Role> cargos = event.getGuild().getRoles();
                for (int i = 0; i < cargos.size(); i++){
                    listaCargos.append(cargos.get(i).getName());
                    if (i < cargos.size() - 1){
                        listaCargos.append("\n");
                    }
                }

                event.reply("**Lista de cargos:** \n" + listaCargos).setEphemeral(true).queue();

            break;

        }

    }
}
