package me.cauadeveloper.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class createCopyRole {

    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        // Preciso criar um split com 3 casas no array, o usuário vai passar três comandos.
        // O slot zero é o !createRoleEmpty, o slot um é o nome do cargo, o slot dois é o nome do cargo existente
        if (event.isFromGuild()) {
            String[] command = event.getMessage().getContentRaw().split(" ", 3);

            if (command[0].equalsIgnoreCase("!createRoleEmpty")) {
                if (command.length < 3) {
                    event.getChannel().sendMessage("Por favor, forneça o nome do cargo.").queue();
                } else {
                    String roleName = command[1];
                    String roleID = command[2];
                    event.getGuild().createCopyOfRole(roleName roleID)
                            .queue(role -> event.getChannel().sendMessage("Cargo `" + roleName + "` criado com sucesso!" +
                                    " As permissões foram cópiadas do cargo " + roleID + "`").queue());
                }
            }
        }
    }

}
