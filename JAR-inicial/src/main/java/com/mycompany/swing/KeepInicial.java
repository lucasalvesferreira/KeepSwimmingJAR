package com.mycompany.swing;

import java.util.Scanner;

public class KeepInicial {

    public static void main(String[] args) {

        Scanner leitorTxt = new Scanner(System.in);
        ///////////////////////////////////////////////
        System.out.println("\n\n===============Tela de Login===============\n\n");
        System.out.println("Insira seu login para continuar!!\n\n");

        System.out.println("Nome de Usuario:\n");
        String EMAIL = leitorTxt.nextLine();
        System.out.println("\nSenha:\n");
        String SENHA = leitorTxt.nextLine();

        valida val = new valida();
        Boolean validou = val.validandoSessao(EMAIL, SENHA);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (validou == true) {

            System.out.println("\n\n=============Envia Token===============\n");
            System.out.println("\nGerando Token\n...");

            EnviaTokenCli envia = new EnviaTokenCli();
            envia.ReenviaCodigo();

            System.out.println("\nDigite o codigo enviado abaixo!\n");
            String guardaCodDigitado = leitorTxt.nextLine();

            if ("".equals(guardaCodDigitado)) {
                System.out.println("Digite um token valido para continuar!!");
                guardaCodDigitado = leitorTxt.nextLine();
            } else if (guardaCodDigitado.equalsIgnoreCase(envia.getGuardaCodig())) {
//           new TelaUsuarioLogado().setVisible(true);
//             new TelaPrincipal(funcionario).setVisible(true);

                System.out.println(envia.getFuncionario());
                TelaPrincipalCli telaPrinc = new TelaPrincipalCli();
                telaPrinc.inicializacao();
//             log.criarLog("Login realizado com sucesso");
            } else {

            }

            System.out.println("Digite um token valido para continuar!!");
            guardaCodDigitado = leitorTxt.nextLine();

        }

    }

}
