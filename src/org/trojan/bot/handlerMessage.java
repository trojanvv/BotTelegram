package org.trojan.bot;


import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Date;


class handlerMessage {

    static SendMessage handler(Update update){
        SendMessage newMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId());

        if (update.hasMessage() && update.getMessage().hasText()){

            switch (update.getMessage().getText().toLowerCase()){
                case "/start":
                    newMessage.setText("Привет, ты попал к нам на канал");
                    break;
                case "/time":
                    newMessage.setText(new Date().toString());
                    break;
                default:
                    newMessage.setText("Такая команда отсутсвует");
            }


        }
        return newMessage;
    }

}
