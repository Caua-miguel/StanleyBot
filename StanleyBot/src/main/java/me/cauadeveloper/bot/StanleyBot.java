package me.cauadeveloper.bot;

import me.cauadeveloper.commands.*;
import me.cauadeveloper.commands.roles.ListOfRoles;
import me.cauadeveloper.commands.roles.createCopyRole;
import me.cauadeveloper.commands.roles.createRoleDefault;
import me.cauadeveloper.commands.roles.createRoleEmpty;
import me.cauadeveloper.database.tables.Table_Funcionarios_Omega;
import me.cauadeveloper.database.dataconfig.Config;
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
            Table_Funcionarios_Omega.insert(1, "Ana Clara");
            Table_Funcionarios_Omega.insert(2, "Paula Fernanda");
            Table_Funcionarios_Omega.insert(3, "Carlos Miguel");
            Table_Funcionarios_Omega.insert(4, "Ana Mendes");
            Table_Funcionarios_Omega.insert(5, "Ana Carla");
        }




    }
}