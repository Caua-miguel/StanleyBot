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
                    " 6 - !EscolherGPSemana\n 7 - !GPSemana\n 8 - !ReportarFalta");
            embed.addField("Cargo Vazio", "O comando **!createRoleEmpty** é usando quando você precisa criar um novo cargo" +
                    " no seu servidor, mas sem nenhuma permissão, para que você configure de acordo com a sua necessidade. \n\nFormato: **<!createRoleEmpty> <nome do cargo>**"
                    , false);
            embed.addField("Cargo Padrão", "O comando **!createRoleDefault** é usando quando você precisa criar um novo cargo" +
                    " no seu servidor com as mesmas permissões do cargo everyone para agilizar a configuração das permissões. \n\nFormato: **<!createRoleDefault> <nome do cargo>**"
                    , false);
            embed.addField("Copia de cargo", " O comando **!createRoleDefault** é usando quando você precisa criar um novo cargo" +
                    " , mas quer copiar as permissões de outro cargo para ter como base. \n\nFormato: **<!createRoleDefault> <nome do novo cargo> <nome do cargo que deseja copiar>**"
                    , false);
            embed.addField("Lista de Cargos", "O comando **!ListRoles** é usado para verificar o nome de todos os cargos dentro do servidor." +
                    "\n\n Formato: **<!listRoles>**", false);
            embed.addField("Latência", "O comando **!ping** é usado quando você quer checar a latência do bot" +
                    "\n\n Formato: **<!ping>**", false);

            // Separar em categorias, o help para os admins e para o resto
            embed.addField("Escolher Grupo da Semana", "O comando **!EscolherGPSemana** é usado quando você quer selecionar um grupo para ser responsável pelo café essa semana, ele atualiza" +
                    " o banco de dados e, portanto, só pode ser usado por cargos especificos." +
                    "\n\n Formato: **<!EscolherGPSemana>**", false);
            embed.addField("Grupo da Semana", "O comando **!GPSemana** é usado quando você quer checar qual grupo está responsável pelo café essa semana" +
                    " Vai ser retornado apenas o nome do grupo responsável e pode ser usado por qualquer um" +
                    "\n\n Formato: **<!GPSemana>**", false);
            embed.addField("Reportar Falta de Recurso", "O comando **!ReportarFalta** é usado quando você quer reportar a falta de um item ou recurso necessário para a preparação do café" +
                    " como leite ou pó de café. Com esse comando, uma menssagem vai ser retornada para o grupo responsável solicitando a reposição do item." +
                    "\n\n Formato: **<!ReportarFalta> <item>**", false);
            channel.sendMessageEmbeds(embed.build()).queue();
        }


    }
}
