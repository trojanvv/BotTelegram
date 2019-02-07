package org.trojan;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.trojan.bot.TrojanBot;

public class Main {

    private static String PROXY_HOST;
    private static Integer PROXY_PORT;

    public static void main(String[] args) {


        ApiContextInitializer.init();
        PropertiesLoad.init();
        PROXY_HOST = PropertiesLoad.getVar("PROXY_HOST");
        PROXY_PORT = Integer.valueOf(PropertiesLoad.getVar("PROXY_PORT"));

        TelegramBotsApi botsApi = new TelegramBotsApi();


        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);

        botOptions.setProxyHost(PROXY_HOST);
        botOptions.setProxyPort(PROXY_PORT);
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);

        try {
            botsApi.registerBot(new TrojanBot(botOptions));

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
