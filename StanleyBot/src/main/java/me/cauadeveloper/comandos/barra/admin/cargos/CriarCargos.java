package me.cauadeveloper.comandos.barra.admin.cargos;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class CriarCargos extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping nomeCargoOption = event.getOption("nome_cargo");
        OptionMapping nomeCargoCopiaOption = event.getOption("nome_cargo_copia");
        Member member = event.getMember();

        if (member == null) {
            event.reply("Não foi possível identificar o membro.").setEphemeral(true).queue();
            return;
        }

        if (!member.hasPermission(Permission.ADMINISTRATOR)){
            event.reply("Você não tem permissão para usar esse comando!").setEphemeral(true).queue();
            return;
        }

        try {
            switch (command){

                case "criar_cargo_padrao":

                    String nomeCargo = nomeCargoOption.getAsString();
                    List<Role> listaCargos = event.getGuild().getRolesByName(nomeCargo, true);

                    if (listaCargos.isEmpty()){
                        event.getGuild().createRole().setName(nomeCargo).queue();
                        event.reply("O cargo `" + nomeCargo + "` foi criado com sucesso!").setEphemeral(true).queue();
                    }else {
                        event.reply("Já existe um cargo com o nome `" + nomeCargo + "`! Por favor forneça outro nome.").setEphemeral(true).queue();
                    }
                    break;
                case "criar_cargo_vazio":
                    String nomeCargoVazio = nomeCargoOption.getAsString();
                    List<Role> listaCargosVazio = event.getGuild().getRolesByName(nomeCargoVazio, true);

                    if (listaCargosVazio.isEmpty()){
                        event.getGuild().createRole().setPermissions(new Permission[]{}).setName(nomeCargoVazio).queue();
                        event.reply("O cargo `" + nomeCargoVazio + "` foi criado com sucesso!").setEphemeral(true).queue();
                    }else {
                        event.reply("Já existe um cargo com o nome `" + nomeCargoVazio + "`! Por favor forneça outro nome.").setEphemeral(true).queue();
                    }
                    break;
                case "criar_cargo_copia":
                    String nomeNovoCargo = nomeCargoOption.getAsString();
                    String nomeCargoCopia = nomeCargoCopiaOption.getAsString();
                    List<Role> listaCargosCopia = event.getGuild().getRolesByName(nomeNovoCargo, true);
                    Role cargoExistente = event.getGuild().getRolesByName(nomeCargoCopia, true).get(0);

                    if (listaCargosCopia.isEmpty()){
                        event.getGuild().createCopyOfRole(cargoExistente).setName(nomeNovoCargo).queue();
                        event.reply("O cargo `" + nomeNovoCargo + "` foi criado com sucesso!").setEphemeral(true).queue();
                    }else {
                        event.reply("Já existe um cargo com o nome `" + nomeNovoCargo + "`! Por favor forneça outro nome.").setEphemeral(true).queue();
                    }
                    break;
            }
        }catch (IndexOutOfBoundsException e){
            event.reply("Cargo não encontrado!").setEphemeral(true).queue();
        }

    }
}
