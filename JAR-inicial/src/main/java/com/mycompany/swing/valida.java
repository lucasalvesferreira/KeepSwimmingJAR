package com.mycompany.swing;

import com.mycompany.swing.Connection;
import com.mycompany.swing.EnviaTokenCli;
import com.mycompany.swing.Funcionario;

import com.mysql.cj.log.Log;
//import com.mycompany.swing.Log;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class valida {

    private String EMAIL;
    private String SENHA;

    public Funcionario validandoSessao(String EMAIL, String SENHA) {

        this.EMAIL = EMAIL;
        this.SENHA = SENHA;

        if (this.EMAIL.equalsIgnoreCase(null) || this.SENHA.equalsIgnoreCase(null)) {
            System.out.println("Login Invalido!!");
            return null;
        }

//          Log log = new Log();
//        log.criarLog("===============Tela de Login===============");
//        log.criarLog("Iniciando tela swing email&senha");
//    
        //////////////Conexão com o banco//////////////
//    //Instancia a classe Connection
        //Instancia um objeto Jdbc e pega o retorno getDataSource
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        List funcionario = new ArrayList();
        Funcionario usuario = new Funcionario();
        BeanPropertyRowMapper Bean = new BeanPropertyRowMapper();

        List<Funcionario> Select = con.query("SELECT"
                + " idFuncionario,"
                + " EMAIL, "
                + "SENHA, "
                + "idMaquina AS Maquina "
                + "from [dbo].[FUNCIONARIO] join"
                + "[dbo].[Maquina] ON idFuncionario = fkUsuario",
                new BeanPropertyRowMapper(Funcionario.class));

        for (Funcionario func : Select) {

            if (func.getEMAIL().equals(this.EMAIL) && func.getSENHA().equals(this.SENHA)) {
                System.out.println("LOGADO COM SUCESSO!");
//                gravar.criarLog("Usuario logado");
                System.out.println("\n=======================================================\n");
                System.out.println("\n\nInciando bot...\n");

                return func;

            } else {
//                gravar.criarLog("Erro na autenticação do usuario");

            }
        }

        System.out.println("Nome de usuário ou senha errados. Por favor tente outra vez. =( ");
        return null;

    }

}
