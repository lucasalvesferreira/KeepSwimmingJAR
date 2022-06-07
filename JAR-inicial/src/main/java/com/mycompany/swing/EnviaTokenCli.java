package com.mycompany.swing;

import java.util.concurrent.ThreadLocalRandom;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class EnviaTokenCli {

    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    private String guardaCodig = "";

    Log gravar = new Log();

    public void setIdsFuncionario(Funcionario idsFuncionario) {
        this.funcionario = idsFuncionario;
    }

    public Boolean getPassou() {
        return passou;
    }

    public void setPassou(Boolean passou) {
        this.passou = passou;
    }
    private Boolean passou = false;

    public String getGuardaCodig() {
        return guardaCodig;
    }

    public void setGuardaCodig(String guardaCodig) {
        this.guardaCodig = guardaCodig;
    }

    public void emiteCodigo() {
        Log log = new Log();
        log.criarLog("Gerando código token");

        Integer enviaCodigo = ThreadLocalRandom.current().nextInt(1000, 5000);
        String codigoFormatado = enviaCodigo.toString();

        setGuardaCodig(codigoFormatado);
    }

    public void ReenviaCodigo() {
        Log log = new Log();
        log.criarLog("======================Envia Token======================");
        log.criarLog("Iniciando tela do token...");

        log.criarLog("Emitindo token");
        emiteCodigo();
        System.out.println(getGuardaCodig());

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new KeepSwimming_TelegramBot(true));
            KeepSwimming_TelegramBot.sendToTelegramToken(guardaCodig);
//            System.out.println("Token enviado!!");
            log.criarLog("Token enviado");

        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.criarLog("Houve um erro ao enviar o token");
        }

    }

}
