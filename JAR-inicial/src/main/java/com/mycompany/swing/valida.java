package com.mycompany.swing;


import com.mycompany.swing.Connection;
import com.mycompany.swing.EnviaTokenCli;
import com.mycompany.swing.Funcionario;

import com.mysql.cj.log.Log;
//import com.mycompany.swing.Log;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class valida {
    
    public Boolean validandoSessao(String EMAIL, String SENHA){
        
        if(EMAIL.equalsIgnoreCase(null)|| SENHA.equalsIgnoreCase(null)){
            System.out.println("Login Invalido!!");
            return false;
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
                + "from [dbo].[FUNCIONARIO] join" +
            "[dbo].[Maquina] ON idFuncionario = fkUsuario",
            new BeanPropertyRowMapper(Funcionario.class));

       
        System.out.println(Select);
        for (Funcionario func : Select)
        {
            if(func.getEMAIL().equals(EMAIL) && func.getSENHA().equals(SENHA)) {
                System.out.println("LOGADO COM SUCESSO!");
//                gravar.criarLog("Usuario logado");
                System.out.println("\n=======================================================\n");
                System.out.println("\n\nInciando bot...\n");
        
                EnviaTokenCli sendtoken = new EnviaTokenCli();
                System.out.println();
            TelaPrincipalCli telaPrinc = new TelaPrincipalCli();
                
            telaPrinc.setIdFunc(func.getIdFuncionario());

           //    new EnviaToken().setVisible(true);
//           gravar.criarLog("Iniciando tela token...");
//               token.setVisible(true);
               return true;
             
            } else {
//                gravar.criarLog("Erro na autenticação do usuario");
                System.out.println("Login ou senhas incorretos!!");
                 return false;
            }
        }
        
      
       
        return false;
        
    }


}
