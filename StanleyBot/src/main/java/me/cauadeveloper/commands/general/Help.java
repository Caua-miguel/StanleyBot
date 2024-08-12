package me.cauadeveloper.commands.general;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();
        EmbedBuilder embed = new EmbedBuilder();

        if(content.equalsIgnoreCase("!help")){

            embed.setTitle("Help");
            embed.setDescription("O StanleyBot é seu auxiliar na preparação do seu café.\n\n" +
                    "Os comandos que nós temos são os seguintes:\n\n 1 - !createRoleEmpty\n 2 - !createRoleDefault\n 3 - !createCopyRole\n 4 - !listRole\n 5 - !ping\n" +
                    " 6 - !EscolherGPSemana\n 7 - !GPSemana\n 8 - !ReportarFalta \n 9 - !startCoffe\n 10 - !Start\n 11 - Comandos de barra (Slash)");
            embed.addField("Cargo Vazio", "O comando **!createRoleEmpty** é usado quando você precisa criar um novo cargo" +
                    " no seu servidor, mas sem nenhuma permissão, para que você configure de acordo com a sua necessidade. \n\nFormato: **<!createRoleEmpty> <nome do cargo>**"
                    , false);
            embed.addField("Cargo Padrão", "O comando **!createRoleDefault** é usado quando você precisa criar um novo cargo" +
                    " no seu servidor com as mesmas permissões do cargo everyone para agilizar a configuração das permissões. \n\nFormato: **<!createRoleDefault> <nome do cargo>**"
                    , false);
            embed.addField("Copia de cargo", " O comando **!createRoleDefault** é usado quando você precisa criar um novo cargo" +
                    " , mas quer copiar as permissões de outro cargo para ter como base. \n\nFormato: **<!createRoleDefault> <nome do novo cargo> <nome do cargo que deseja copiar>**"
                    , false);
            embed.addField("Lista de Cargos", "O comando **!ListRoles** é usado para verificar o nome de todos os cargos dentro do servidor." +
                    "\n\n Formato: **<!listRoles>**", false);
            embed.addField("Latência", "O comando **!ping** é usado quando você quer checar a latência do bot" +
                    "\n\n Formato: **<!ping>**", false);
            embed.addField("Escolher Grupo da Semana", "O comando **!EscolherGPSemana** é usado quando você quer selecionar um grupo para ser responsável pelo café essa semana, ele atualiza" +
                    " o banco de dados e, portanto, só pode ser usado por cargos especificos." +
                    "\n\n Formato: **<!EscolherGPSemana>**", false);
            embed.addField("Grupo da Semana", "O comando **!GPSemana** é usado quando você quer checar qual grupo está responsável pelo café essa semana" +
                    " Vai ser retornado apenas o nome do grupo responsável e pode ser usado por qualquer um" +
                    "\n\n Formato: **<!GPSemana>**", false);
            embed.addField("Reportar Falta de Recurso", "O comando **!ReportarFalta** é usado quando você quer reportar a falta de um item ou recurso necessário para a preparação do café" +
                    " como leite ou pó de café. Com esse comando, uma menssagem vai ser retornada para o grupo responsável solicitando a reposição do item." +
                    "\n\n Formato: **<!ReportarFalta> <item>**", false);
            embed.addField("Timer", "O comando **!startCoffe** é usado como um aviso, ao ser usado ele vai funcionar como um cronometro, depois do tempo passado em **MINUTOS**" +
                    " o bot vai enviar um aviso para te lembrar que o seu café está pronto. Caso você não passe parâmetro ele vai retornar um tempo padrão para o preparo do café." +
                    " Nesse caso, o tempo vai ser de 10 minutos. Obs: O tempo padrão **NÃO** foi baseado em estudos cientificos." +
                    "\n\n Formato: **<!startCoffe> <numero inteiro>**", false);
            embed.addField("Iniciar", "O comando **!Start** é solicitado para ser usado assim que o bot entra no servidor, ele vai dar algumas instruções para o usuário sobre como" +
                    " inserir os dados dos colaboradores inicialmente nas tabelas. Ele também te retorna um arquivo **grupos.xls** que vai ser usado nesse trabalho inicial.\n\n Formato: **<!Start>**", false);
            embed.addField("Slash", "Os comandos de barra estão sendo implementados atualmente, até o momento temos quatro comandos.\n 1 - adicionar_func_time\n 2 - adicionar_func\n 3 - atualizar_func\n 4 - remover_func\n" +
                    "Esses comandos servem para o administrador ajustar as tabelas do banco de dados, adicionando, atualizando, deletando os funcionários e atribuindo eles a um time" +
                    "\n Formato: **</nome_do_comando>**", false);
            channel.sendMessageEmbeds(embed.build()).queue();
        }


    }
}
