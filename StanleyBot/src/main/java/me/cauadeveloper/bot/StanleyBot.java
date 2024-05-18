package me.cauadeveloper.bot;

import me.cauadeveloper.commands.*;
import me.cauadeveloper.commands.roles.ListOfRoles;
import me.cauadeveloper.commands.roles.createCopyRole;
import me.cauadeveloper.commands.roles.createRoleDefault;
import me.cauadeveloper.commands.roles.createRoleEmpty;
import me.cauadeveloper.database.tables.*;
import me.cauadeveloper.database.dataconfig.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
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

        for (int i = 1; i < 4; i++ ) {
            Table_Funcionarios_Omega.insert(i, "Ana Clara", "contabilidade blabla", "financeiro", true);
            Table_Funcionarios_Omega.insert(i, "Paula Fernanda", "refaturação blabla", "programador", true);
            Table_Funcionarios_Omega.insert(i, "Carlos Miguel", "gerencia", "chefe fodase", true);
        }

        for (int i = 1; i < 4; i++ ) {
            Table_Funcionario_Grupo.insert(i, i, i, true);
            Table_Funcionario_Grupo.insert(i, i, i, true);
            Table_Funcionario_Grupo.insert(i, i, i, true);
        }

        for (int i = 1; i < 4; i++ ) {
            Table_Time.insert(i, "teste", true);
            Table_Time.insert(2, "Reposicao132", true);
            Table_Time.insert(3, "CoaLegal123", true);
        }

        for (int i = 1; i < 4; i++ ) {
            Table_Tarefa.insert(1, "Reposicao");
            Table_Tarefa.insert(2, "Esquentar agua");
            Table_Tarefa.insert(3, "Coar o cafe");
        }

        for (int i = 1; i < 4; i++ ) {
            Table_Time_Tarefa.insert(i, i, i, true);
            Table_Time_Tarefa.insert(i, i, i, true);
            Table_Time_Tarefa.insert(i, i, i, true);
        }


    }
}