package me.cauadeveloper.bot;

import me.cauadeveloper.commands.*;
import me.cauadeveloper.commands.roles.ListOfRoles;
import me.cauadeveloper.commands.roles.createCopyRole;
import me.cauadeveloper.commands.roles.createRoleDefault;
import me.cauadeveloper.commands.roles.createRoleEmpty;
import me.cauadeveloper.database.CRUD;
import me.cauadeveloper.database.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class StanleyBot {

    public static Map<String, Character> prefixMap = new HashMap<>();

    public static void main(String[] args) throws Exception{

        Config.createFilesAndTable();

        JDA jda = JDABuilder.createDefault(System.getenv("TOKEN"),
                EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new ping());
        jda.addEventListener(new createRoleEmpty(), new createRoleDefault(), new createCopyRole());
        jda.addEventListener(new ListOfRoles());
        jda.addEventListener(new Prefix());
        jda.addEventListener(new Help());

        for (Guild guild : jda.awaitReady().getGuilds()) {
            CRUD.insert(guild.getId(), '!');
        }

        for (Guild guild : jda.awaitReady().getGuilds()) {
            CRUD.select(guild.getId());
        }

    }
}