package me.cauadeveloper.comandos.cargos;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.List;

public class ListarCargos extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        Message message = event.getMessage();
        String content = message.getContentRaw();
        List<Role> roles = event.getGuild().getRoles();
        MessageChannel channel = event.getChannel();

        if(content.equalsIgnoreCase("!listRoles")) {
            channel.sendMessage("Segue a lista de cargos: \n").queue();
            for (Role role : roles) {
                String roleName = role.getName();
                channel.sendMessage(roleName).queue();
            }
        }

    }

}
