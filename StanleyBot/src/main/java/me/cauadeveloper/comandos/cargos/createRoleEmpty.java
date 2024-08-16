package me.cauadeveloper.comandos.cargos;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class createRoleEmpty extends ListenerAdapter {

    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (event.isFromGuild()) {
            String[] command = event.getMessage().getContentRaw().split(" ", 2);

            if (command[0].equalsIgnoreCase("!createRoleEmpty")) {
                if (command.length < 2) {
                    event.getChannel().sendMessage("Por favor, forneça o nome do cargo.").queue();
                } else {
                    String roleName = command[1];
                    event.getGuild().createRole()
                            .setPermissions(new Permission[]{})
                            .setName(roleName)
                            .queue(role -> event.getChannel().sendMessage("Cargo `" + roleName + "` criado com sucesso!").queue());
                }
            }
        }
    }
}
