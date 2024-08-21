package me.cauadeveloper.comandos.barra.listas;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class ListarCagos extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();

        switch (command){

            case "listar_cargos":

                List<Role> cargos = event.getGuild().getRoles();
                for (int i = 0; i < cargos.size(); i++){
                    String cargoAtual = cargos.get(i).getName();
                    event.getChannel().sendMessage(cargoAtual).queue();
                }
            break;

        }

    }
}
