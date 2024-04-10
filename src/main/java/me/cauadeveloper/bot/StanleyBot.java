package me.cauadeveloper.bot;

import me.cauadeveloper.commands.goodNight;
import me.cauadeveloper.commands.ping;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class StanleyBot {

    public static void main(String[] args) throws Exception{
        JDA jda = JDABuilder.createDefault("",
        EnumSet.allOf(GatewayIntent.class)).build();
        jda.addEventListener(new ping());
        jda.addEventListener(new goodNight());
    }
}