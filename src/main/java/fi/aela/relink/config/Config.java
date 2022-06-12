package fi.aela.relink.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;

import fi.aela.relink.Relink;

public class Config {

    static Logger LOGGER = Relink.LOGGER;

    public static String getToken() {
        File file = new File("config/relink.conf");
        File folder = new File("config");
        if (!folder.exists()){
            folder.mkdirs();
        }

        try {
            if (file.createNewFile()) {
                LOGGER.info("Created blank config file");
                FileWriter writer = new FileWriter(file);
                writer.write("insert bot token here");
                writer.write("\n");
                writer.write("insert channel id here");
                writer.close();
            } else {
                LOGGER.info("Existing config file found");
            }
        } catch (IOException e) {}
        try {
            Scanner scanner = new Scanner(file);
            String token = scanner.nextLine();
            scanner.close();
            return token;
            
        } catch (FileNotFoundException e1) {}
        return null;
    }

    public static String getChannel() {
        File file = new File("config/relink.conf");
        try {
            Scanner scanner = new Scanner(file);
            String channel = scanner.nextLine();
            channel = scanner.nextLine();
            scanner.close();
            return channel;
            
        } catch (FileNotFoundException e1) {}
        return null;
    }
}
