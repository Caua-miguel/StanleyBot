package me.cauadeveloper.bot;

import me.cauadeveloper.commands.createRoleEmpty;
import me.cauadeveloper.commands.goodNight;
import me.cauadeveloper.commands.ping;
import me.cauadeveloper.commands.Help;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import java.util.EnumSet;

public class StanleyBot {

    public static void main(String[] args) throws Exception{
        JDA jda = JDABuilder.createDefault("MTIyNjY1MzQyMzE4MTYzMTY0OQ.GY4tKT.iIUSQjA4Pmb-t2zgCTlFcVVX_AcmvFxmRypZl8",
        EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new ping());
        jda.addEventListener(new goodNight());
        jda.addEventListener(new createRoleEmpty());
        jda.addEventListener(new Help());
    }
}