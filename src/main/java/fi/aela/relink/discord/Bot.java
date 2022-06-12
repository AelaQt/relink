package fi.aela.relink.discord;

import javax.security.auth.login.LoginException;

import org.slf4j.Logger;

import fi.aela.relink.Relink;
import fi.aela.relink.config.Config;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot extends ListenerAdapter {

    Logger LOGGER = Relink.LOGGER;

    public static void build() throws LoginException
    {
        JDABuilder.createLight(Config.getToken(), GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
            .addEventListeners(new Bot())
            .setActivity(Activity.playing("Minecraft"))
            .build();
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String channel = event.getChannel().getId();
        if (channel.equals(Config.getChannel())) {
            String message = "[Discord] <" + event.getAuthor().getName() + "> " + event.getMessage().getContentRaw();
            LOGGER.info(message);
        }
    }
}