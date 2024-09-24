package me.cauadeveloper.comandos.geral;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.awt.*;

public class Help extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        OptionMapping opHelp = event.getOption("help_argumento");
        EmbedBuilder embed = new EmbedBuilder();
        EmbedBuilder embedAdm = new EmbedBuilder();
        EmbedBuilder embedUser = new EmbedBuilder();

        if (command.equalsIgnoreCase("help")){

            // Sem argumento
                embed.setTitle("HELP");
                embed.setDescription("O StanleyBot é seu auxiliar na preparação do seu café.\n\n" +
                        "Os comandos que temos são separados para o administrador e para o usuário padrão. Use o comando `/help adm` para visualizar o que o administrador pode fazer ou" +
                                     " use o comando `/help usuario` para ver os comandos que todos podem usar.");

            // Admin

                embedAdm.setTitle("HELP");
                embedAdm.setColor(Color.decode("#D2691E"));
                embedAdm.setDescription("Os comandos que o administrador pode usar são: \n\n" +
                        "1 - /iniciar \n\n 2 - /inserir dados iniciais \n\n 3 - /criar cargo \n\n 4 - /adicionar* \n\n 5 - /atualizar* \n\n 6 - /remover* \n\n 7 - /escolher time da semana\n\n" +
                        "**Iniciar**\n\n O comando iniciar vai dar instruções básicas de como cadastrar funcionários, times e tarefas. Ele vai gerar um .xls para o administrador do servidor preencher.\n\n **Cuidado para preencher os dados corretamente!**\n\n" +
                        "**Inserir dados iniciais**\n\n O comando inserir dados iniciais vai solicitar o arquivo que o administrador do servidor editou usando o comando `/iniciar`. Assim que você passar esse arquivo, os dados serão cadastrados.\n\n" +
                        "**Criar Cargo**\n\n O comando criar cargos vai criar um cargo tem três opções, criar o cargo sem nenhuma permissão (vazio), com as permissões de @everyone (padrão) ou pode copiar as permissões de outro cargo (copia).\n\n" +
                        "Você pode digitar `criar_cargo` para verificar as três opções.\n\n" +
                        "**Adicionar / atualizar / remover**\n\n Os comandos adicionar, atualizar e remover servem para ajustar o cadastro de um funcionário, um time ou tarefa no banco de dados.\n\n" +
                        "**Escolher time da semana**\n\n O comando escolher time da semana vai ser usado apenas uma vez e sem argumentos. Esse comando vai selecionar um time para ficar responsável pelo café durante a semana.\n\n" +
                        " **A partir do momento que esse comando for usado uma vez, ele vai rodar sem parar selecionando um novo time a cada 7 dias!**");

            // Usuario

                embedUser.setTitle("HELP");
                embedUser.setColor(Color.decode("#00BFFF"));
                embedUser.setDescription("Os comandos que todos podem usar são:\n\n" +
                        "1 - /listar* \n\n 2 - /cronometro \n\n 3 - /help \n\n 4 - /ping \n\n 5 - /reportar falta \n\n 6 - /time da semana\n\n" +
                        "**Listas** \n\nOs comandos de lista servem para o usuário verificar quais funcionários, times e tarefas foram cadastrados. Além disso você pode listar os cargos do seu servidor e quais funcionários" +
                        " fazem parte de um time específico. \n\n Para verificar uma lista basta digitar `/listar` que você pode selecionar qual lista deseja.\n\n" +
                        "**Cronometro**\n\n O cronometro serve como uma notificação para o preparo do café ou qualquer outra tarefa que preferir.\n\n Você deve usar os argumentos em **MINUTOS**." +
                        " Caso não use nenhum, o bot vai te notificar em 10 minutos por padrão.\n\n" +
                        "**Ping**\n\n O comando ping retorna a velocidade da conexão do bot em milissegundos.\n\n" +
                        "**Reportar falta**\n\n O comando reportar falta manda uma mensagem para todos no servidor solicitando a reposição do recurso faltante. Foi criado para reposição de insumos, mas pode ser usado para outras coisas." +
                        " Portanto, use da maneira adequada.\n\n" +
                        "**Time da semana**\n\n O comando time da semana mostra qual time foi escolhido para ser responsável pelo café durante essa semana.");

                try {

                    String cargo = opHelp.getAsString();

                    switch (cargo){

                        case "adm":

                            event.replyEmbeds(embedAdm.build()).setEphemeral(true).queue();

                        break;

                        case "usuario":
                        case "usuário":
                        case "user":

                            event.replyEmbeds(embedUser.build()).setEphemeral(true).queue();

                        break;

                        default:
                            event.reply("Não reconheço esse argumento! Tenha certeza de ter passado `adm` ou `usuario`, dessa forma:\n `/help <adm>` ou `/help <usuario>`").setEphemeral(true).queue();
                        break;
                    }

                }catch (NullPointerException e){
                    event.replyEmbeds(embed.build()).setEphemeral(true).queue();
                }






        }

    }
}
