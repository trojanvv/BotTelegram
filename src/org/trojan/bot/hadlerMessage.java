package org.trojan.bot;

import org.telegram.telegrambots.api.objects.Update;

public class hadlerMessage {

    static public void handler(Update update){

        if (update.hasMessage() && update.getMessage().hasText()){

            switch (update.getMessage().getText()){
                case "привет":

            }
        }

    }

}
