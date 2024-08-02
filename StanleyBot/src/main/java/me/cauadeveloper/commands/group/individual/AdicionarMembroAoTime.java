package me.cauadeveloper.commands.group.individual;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.utils.FileUpload;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

import static me.cauadeveloper.utils.files.member.inputMemberOnTeam.inputMemberDefault;
import static me.cauadeveloper.utils.files.member.outputMemberTeam.writeFileDefaltMember;

public class AdicionarMembroAoTime extends ListenerAdapter {

    // Vai ser um slash command - o usuário tem que conseguir escolher os nomes dos funcionários que foram adicionados na tabela inicial
    // e os funcionários que ele escoleher vai ajustar o idTime da tabela funcionário de acordo com o id dos times.

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        String command = event.getName();
        if (command.equals("welcome")){
            String userTag = event.getUser().getAsTag();
            event.reply("Welcome to the server, **" + userTag + "**!").queue();
        }
    }

    //Guild command -- instantly update (max 100)

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event){

        // Vou precisar adicionar uma lista com os nomes dos funcionário para criar várias opções no comando.
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("welcome", "Get welcomed by the bot."));
        event.getGuild().updateCommands().addCommands(commandData).queue();

//        if (event.getGuild().getIdLong() == id do servidor){} -- server para fazer commando especifico para o servidor

    }

}
