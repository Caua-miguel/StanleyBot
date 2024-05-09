package me.cauadeveloper.bot;

import me.cauadeveloper.commands.*;
import me.cauadeveloper.commands.roles.ListOfRoles;
import me.cauadeveloper.commands.roles.createCopyRole;
import me.cauadeveloper.commands.roles.createRoleDefault;
import me.cauadeveloper.commands.roles.createRoleEmpty;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import java.util.EnumSet;

public class StanleyBot {

    public static void main(String[] args) throws Exception{
        JDA jda = JDABuilder.createDefault(System.getenv("TOKEN"),
        EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new ping());
        jda.addEventListener(new goodNight());
        jda.addEventListener(new createRoleEmpty(), new createRoleDefault(), new createCopyRole());
        jda.addEventListener(new ListOfRoles());
        jda.addEventListener(new Help());
    }
}