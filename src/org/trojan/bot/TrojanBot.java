package org.trojan.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TrojanBot extends TelegramLongPollingBot {

    private String BotUsername = "TrojanBot";
    private String BotToken = "320949357:AAG1qFA-dQ0a2iEgiojOxU7WN0lpMrt09B0";



    public void onUpdateReceived(Update update) {

    }


    public String getBotUsername() {
        return BotUsername;
    }


    public String getBotToken() {
        return BotToken;
    }
}
