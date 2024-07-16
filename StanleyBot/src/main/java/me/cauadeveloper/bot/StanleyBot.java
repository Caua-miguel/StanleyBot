package me.cauadeveloper.bot;

import me.cauadeveloper.commands.general.*;
import me.cauadeveloper.commands.group.EscolherGrupoSemana;
import me.cauadeveloper.commands.group.GrupoSemana;
import me.cauadeveloper.commands.roles.ListOfRoles;
import me.cauadeveloper.commands.roles.createCopyRole;
import me.cauadeveloper.commands.roles.createRoleDefault;
import me.cauadeveloper.commands.roles.createRoleEmpty;
import me.cauadeveloper.commands.task.ReportarFaltaRecurso;
import me.cauadeveloper.database.dataconfig.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class StanleyBot {

    // Ta com problema no prefixMap
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
        jda.addEventListener(new EscolherGrupoSemana());
        jda.addEventListener(new GrupoSemana());
        jda.addEventListener(new ReportarFaltaRecurso());
        jda.addEventListener(new start());
        jda.addEventListener(new pathDB());
    }
}