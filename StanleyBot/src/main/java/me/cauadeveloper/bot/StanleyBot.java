package me.cauadeveloper.bot;

import me.cauadeveloper.comandos.geral.*;
import me.cauadeveloper.comandos.barra.config.addSlashCommands;
import me.cauadeveloper.comandos.barra.time.EscolherGrupoSemana;
import me.cauadeveloper.comandos.barra.time.GrupoSemana;
import me.cauadeveloper.comandos.barra.funcionario.relacao_func_time.add_func_ao_time;
import me.cauadeveloper.comandos.barra.funcionario.add_atualiza_remove_func;
import me.cauadeveloper.comandos.cargos.ListOfRoles;
import me.cauadeveloper.comandos.cargos.createCopyRole;
import me.cauadeveloper.comandos.cargos.createRoleDefault;
import me.cauadeveloper.comandos.cargos.createRoleEmpty;
import me.cauadeveloper.comandos.tarefa.ListaDeTarefas;
import me.cauadeveloper.comandos.tarefa.ReportarFaltaRecurso;
import me.cauadeveloper.sqlite.config_banco.Config;
import me.cauadeveloper.boas_vindas.Apresentacao;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import java.util.EnumSet;

public class StanleyBot {

    public static void main(String[] args) throws Exception{

        Config.createFilesAndTable();

        JDA jda = JDABuilder.createDefault(System.getenv("TOKEN"),
                EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new ping());
        jda.addEventListener(new createRoleEmpty(), new createRoleDefault(), new createCopyRole());
        jda.addEventListener(new ListOfRoles());
        jda.addEventListener(new Help());
        jda.addEventListener(new EscolherGrupoSemana());
        jda.addEventListener(new GrupoSemana());
        jda.addEventListener(new ReportarFaltaRecurso());
        jda.addEventListener(new start());
        jda.addEventListener(new userDataTables());
        jda.addEventListener(new timer());
        jda.addEventListener(new Apresentacao());
        jda.addEventListener(new add_atualiza_remove_func());
        jda.addEventListener(new add_func_ao_time());
        jda.addEventListener(new addSlashCommands());
        jda.addEventListener(new ListaDeTarefas());

    }
}