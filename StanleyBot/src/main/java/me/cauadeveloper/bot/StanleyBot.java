package me.cauadeveloper.bot;

import me.cauadeveloper.comandos.admin.cargos.CriarCargos;
import me.cauadeveloper.comandos.admin.funcionario.AdicionarAtualizarRemoverFunc;
import me.cauadeveloper.comandos.admin.funcionario.relacao_func_time.AdicionarFuncAoTime;
import me.cauadeveloper.comandos.admin.geral.Iniciar;
import me.cauadeveloper.comandos.admin.geral.InserirDadosIniciais;
import me.cauadeveloper.comandos.admin.time.AdicionarAtualizarRemoverTime;
import me.cauadeveloper.comandos.admin.time.EscolherTimeSemana;
import me.cauadeveloper.comandos.config.RegistrarComandos;
import me.cauadeveloper.comandos.geral.*;
import me.cauadeveloper.comandos.geral.listas.*;
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

        jda.addEventListener(new Ping());
        jda.addEventListener(new CriarCargos());
        jda.addEventListener(new Help());
        jda.addEventListener(new EscolherTimeSemana());
        jda.addEventListener(new TimeSemana());
        jda.addEventListener(new ReportarFaltaRecurso());
        jda.addEventListener(new Iniciar());
        jda.addEventListener(new InserirDadosIniciais());
        jda.addEventListener(new Cronometro());
        jda.addEventListener(new Apresentacao());
        jda.addEventListener(new AdicionarAtualizarRemoverFunc());
        jda.addEventListener(new AdicionarFuncAoTime());
        jda.addEventListener(new RegistrarComandos());
        jda.addEventListener(new ListarDeTarefas());
        jda.addEventListener(new ListarCagos());
        jda.addEventListener(new ListarTimes());
        jda.addEventListener(new ListarFuncionarios());
        jda.addEventListener(new ListarFuncDoTime());
        jda.addEventListener(new AdicionarAtualizarRemoverTime());

    }
}