package me.cauadeveloper.commands.roles;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class createCopyRole extends ListenerAdapter {

    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (event.isFromGuild()) {
            String[] command = event.getMessage().getContentRaw().split(" ", 3);

            if (command[0].equalsIgnoreCase("!createCopyRole")) {
                if (command.length < 3) {
                    event.getChannel().sendMessage("Por favor, forneça o nome do cargo e o nome do cargo que deseja copiar.").queue();
                } else {
                    String roleName = command[1];
                    String existingRoleName = command[2];

                    Role existingRole = event.getGuild().getRolesByName(existingRoleName, true).get(0);

                    if (existingRole != null) {
                        event.getGuild().createCopyOfRole(existingRole)
                                .setName(roleName)
                                .queue(role -> event.getChannel().sendMessage("Cargo `" + roleName + "` criado com sucesso!").queue());
                    }else{
                        event.getChannel().sendMessage("Cargo `" + existingRoleName + "` não encontrado.").queue();
                    }
                }
            }
        }
    }

}
