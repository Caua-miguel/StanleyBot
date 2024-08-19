package me.cauadeveloper.comandos.cargos;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CargoVazio extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping nomeCargoOption = event.getOption("nome_cargo");
        Member member = event.getMember();


        if (member.hasPermission(Permission.ADMINISTRATOR) && event.isFromGuild() && command.equalsIgnoreCase("criar_cargo_vazio")){

            String nomeCargo = nomeCargoOption.getAsString();
            List<Role> listaCargos = event.getGuild().getRolesByName(nomeCargo, true);

                if (listaCargos.isEmpty()){
                    event.getGuild().createRole().setPermissions(new Permission[]{}).setName(nomeCargo).queue();
                    event.reply("O cargo `" + nomeCargo + "` foi criado com sucesso!").setEphemeral(true).queue();
                }else {
                    event.reply("Já existe um cargo com o nome `" + nomeCargo + "`! Por favor forneça outro nome.").setEphemeral(true).queue();
                }

        }else {
            event.reply("Você não tem permissão para usar esse comando!").setEphemeral(true).queue();
        }
    }
}
