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
        Funcionario validou = val.validandoSessao(EMAIL, SENHA);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (validou != null) {

            System.out.println("\n\n=============Envia Token===============\n");
            System.out.println("\nGerando Token\n...");

            EnviaTokenCli envia = new EnviaTokenCli();
            envia.ReenviaCodigo();

            System.out.println("\nDigite o codigo enviado abaixo!\n");
            String guardaCodDigitado = leitorTxt.nextLine();

            if (guardaCodDigitado.equals(envia.getGuardaCodig())) {

                TelaPrincipalCli telaPrinc = new TelaPrincipalCli(validou);

                

            } else {
                System.out.println("Digite um token valido para continuar!!");

            }

        }

    }

}
