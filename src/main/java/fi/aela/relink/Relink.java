package fi.aela.relink;

import net.fabricmc.api.ModInitializer;

import javax.security.auth.login.LoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.aela.relink.config.Config;
import fi.aela.relink.discord.Bot;

public class Relink implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("relink");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello world!");
		String token = Config.getToken();
		LOGGER.info(token);
		String channel = Config.getChannel();
		LOGGER.info(channel);
		try {
			Bot.build();
		} catch (LoginException e) {}
	}
}
