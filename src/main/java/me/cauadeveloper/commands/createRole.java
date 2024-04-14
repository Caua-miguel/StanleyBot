package me.cauadeveloper.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class createRole extends ListenerAdapter {

    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.isFromGuild()) {
            String[] command = event.getMessage().getContentRaw().split(" ", 2);

            if (command[0].equalsIgnoreCase("!createRole")) {
                if (command.length < 2) {
                    event.getChannel().sendMessage("Por favor, forneça o nome do cargo.").queue();
                } else {
                    String roleName = command[1];
                    event.getGuild().createRole()
                            .setName(roleName)
                            .queue(role -> event.getChannel().sendMessage("Cargo `" + roleName + "` criado com sucesso!").queue());
                }
            }
        }
    }
}
