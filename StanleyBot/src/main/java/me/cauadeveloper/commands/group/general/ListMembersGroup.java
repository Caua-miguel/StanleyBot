package me.cauadeveloper.commands.group.general;

import me.cauadeveloper.database.tables.table_time;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;

public class ListMembersGroup extends ListenerAdapter {

    //Preciso usar o idTime da tabela funcionario para retornar a lista de funcionários que está em cada grupo


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        try {
            String[] command = event.getMessage().getContentRaw().split(" ", 2);
            String currentNameGroup = table_time.select();

//            if (command[0].equalsIgnoreCase("!ListMember")){
//
//                if (command[1] == currentNameGroup){
//                                                                                                            //Nomes funcionários do grupo selecionado
//                    event.getChannel().sendMessage("lista de usuário do time " + currentNameGroup + ":\n" + selectNomesLista).queue();
//
//                }
//            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ArrayIndexOutOfBoundsException e){

            event.getChannel().sendMessage("Por favor adicione o nome do time para que eu posso te passar a lista de membros!").queue();

        }


    }
}
