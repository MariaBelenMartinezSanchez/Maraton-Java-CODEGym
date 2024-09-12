package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymMaratonJava_bot";
    public static final String TOKEN = "7509332799:AAFy4YEVVHP0HN7zK0KjIA0Dp8e1D4D-n-8";

    public MyFirstTelegramBot() { super (NAME, TOKEN);}

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        //si se escribe hola -> (entonces) contestar -> (salida)
        //NIVEL 1 ******************************************************************************************************
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }
        //NIVEL 2 ******************************************************************************************************
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha \uD83C\uDF2D! +20 de fama", "step_2_btn",
                            "¡Tomar un pescado \uD83D\uDC1F! + 20 de fama!", "step_2_btn",
                            "¡Tirar una lata de pepinillos \uD83E\uDD52! + 20 de fama", "step_2_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("¡Hackear al Robot aspiradora \uD83E\uDD16 \uD83C\uDF2D! ", "step_3_btn"));
        }
        //NIVEL 3 ******************************************************************************************************
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot por comida \uD83D\uDE0E! +30 de fama", "step_4_btn",
                            "Dar un paseo al robot \uD83D\uDE3A! + 30 de fama!", "step_4_btn",
                            "¡Huir del robot aspirador \uD83C\uDFC3 \uD83D\uDE40! + 30 de fama", "step_4_btn"));
        }
        //FINAL DEL NIVEL 3 ******************************************************************************************************
        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("¡póntela y enciéndela \uD83D\uDCBB \uD83D\uDD25!", "step_5_btn"));
        }
        //NIVEL 4 ******************************************************************************************************
        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            addUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Un jueguete \uD83E\uDDF8 ! +40 de fama", "step_6_btn",
                            "Tener un premio por ganarle al robot \uD83D\uDE3A \uD83C\uDFC6 ! + 40 de fama!", "step_6_btn",
                            "¡Tomar leche \uD83E\uDD5B! + 40 de fama", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            addUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("¡hackea la contraseña de la computadora!", "step_7_btn"));
        }
        //NIVEL 5 ******************************************************************************************************
        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            addUserGlory(50);
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("RECLAMAR RECOMPENSA \uD83E\uDD11 \uD83D\uDCB0 \uD83D\uDE3B !", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            addUserGlory(50);
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of("Jugar de nuevo \uD83C\uDFAE \uD83D\uDC08","step_1_btn"));

        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}