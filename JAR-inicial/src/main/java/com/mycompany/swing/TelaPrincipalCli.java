package com.mycompany.swing;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TelaPrincipalCli {
    
     private Funcionario funcionario;
     private Integer idFunc;
     
        public TelaPrincipalCli() {
        
//        this.funcionario = idsFuncionario;
               
//        inicializacao();
    }

    public Integer getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public TelaPrincipalCli(Integer idFunc) {
        this.idFunc = idFunc;
    }


    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
     public void inicializacao(){
        Log gravar = new Log();
        gravar.criarLog("===============Tela Principal===============");

        // classe de de conexão com o banco
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        
        //conexão com o banco MySQL
        Boolean mysql = true;
        Connection configMysql = new Connection(mysql);
        JdbcTemplate conLocal = new JdbcTemplate(configMysql.getDatasource());
        
        // looca
        com.github.britooo.looca.api.core.Looca looca = new com.github.britooo.looca.api.core.Looca();

        // Insersão dos dados do sistema no banco
        LoocaSistema loocadb = new LoocaSistema();
        
  //---------------------------- ID DA MAQUINA ---------------------------------
  
        List<maquina> idMaquina = con.query("select idMaquina from [dbo].[Maquina] \n" +
                            "JOIN [dbo].[FUNCIONARIO] on fkUsuario = idFuncionario \n" +
                            "WHERE idFuncionario = " + 2,
            new BeanPropertyRowMapper(maquina.class));

        System.out.println( "pegando o ID MAQUINA" + idMaquina.toString());
        
        Integer idDaMaquina = idMaquina.get(0).getIdMaquina();
  
  //---------------------------- INSERT DE MAQUINA -----------------------------
  
        // Listando e inserindo dados do Sistema no banco
       // String sO = looca.getSistema().getSistemaOperacional();
        //String fabricante = looca.getSistema().getFabricante();
        //Integer arquitetura = looca.getSistema().getArquitetura();
        //String permissao = looca.getSistema().getPermissao().toString();
        
        // String inserirDadosMaquina = "Insert into Maquina VALUES "
          //      + "(null,2,?,?,?,?);";
        
        //AZURE
       //  String inserirDadosMaquina = "Insert into Maquina VALUES "
         //       + "(?,?,?,?,?,null);";

        //con.update(inserirDadosMaquina,idMaquina, sO, fabricante, arquitetura, permissao);
        
       // List<LoocaSistema> LoocaSistema = con.query("select * from Maquina",
         //       new BeanPropertyRowMapper<>(LoocaSistema.class));
        
        //loocadb.setsistemaOperacional(sO);
        //loocadb.setfabricante(fabricante);
        //loocadb.setarquitetura(arquitetura);
        //loocadb.setpermissoes(permissao);
        
        //dadosMaquina.setText(loocadb.toString());
        
        
        //for (LoocaSistema sistema : LoocaSistema) {

          //  System.out.println(sistema);
        //}
        
//------------------------------ INSERT DE PROCESSOS ---------------------------
   
        System.out.println("=".repeat(40));
        Date dataHoraProcesso = new Date();
        
        List<Processo> processos = looca.getGrupoDeProcessos().getProcessos();
       
        
          Timer timer = new Timer();
         Integer delay = 1000;
         Integer interval = 5000;
              
        timer.scheduleAtFixedRate(new TimerTask() {
             @Override
             public void run() {
                 
            gravar.criarLog("Inserindo dados no BD...");
        for(int i = 0; i < processos.size(); i++)
        {
           Integer PID = processos.get(i).getPid();
           String Nome = processos.get(i).getNome();
           Double UsoCpu = processos.get(i).getUsoCpu();
           Double usoMemoria = processos.get(i).getUsoMemoria();
           Long bytesUtilizados = processos.get(i).getBytesUtilizados();
           Long memVirtualUtilizada = processos.get(i).getMemoriaVirtualUtilizada();        
           Integer totalProcessos = looca.getGrupoDeProcessos().getTotalProcessos();
           Integer threads = looca.getGrupoDeProcessos().getTotalThreads();
            
                //para MySQL local
            String inserirDadosProcessosLocal = "Insert into Processos VALUES "
              + "(null,1,?,?,?,?,?,?,?,?);";
            conLocal.update(inserirDadosProcessosLocal,idDaMaquina, PID,Nome,UsoCpu,usoMemoria,
                   bytesUtilizados,memVirtualUtilizada, totalProcessos, threads,dataHoraProcesso);
            
              //Para azure
            String inserirDadosProcessos = "Insert into Processos VALUES "
              + "(?,?,?,?,?,?,?,?,?,?);";
            con.update(inserirDadosProcessos,idDaMaquina, PID,Nome,UsoCpu,usoMemoria,
                   bytesUtilizados,memVirtualUtilizada, totalProcessos, threads,dataHoraProcesso);
            }
           
        }
    },delay,interval);
        
        for (Processo processo : processos) {

            System.out.println(processo);
        }
          
//----------------------------INSERT COMPONENTES HARDWARE----------------------
    

        DiscosGroup disco = new DiscosGroup();
        Memoria memoria = new Memoria();
        Processador processador = new Processador();
        
         List<Disco> listaDeDisco = disco.getDiscos();
                     
           for (int i = 0; i < listaDeDisco.size(); i++) {
            
             String nomeDisco = disco.getDiscos().get(i).getNome();
             Long tamanhoDisco = disco.getDiscos().get(i).getTamanho();
             String modeloDisco = disco.getDiscos().get(i).getModelo();
             Integer qtdDiscos = disco.getQuantidadeDeDiscos();
             Long memoriaTotal = memoria.getTotal();
             String processadorNome = processador.getNome();
             
            //Para Mysql local
        String inserirDadosHardwareLocal = "Insert into ComponentesHardware VALUES" 
                  + "(null,1,?,?,?,?,?,?);";
        conLocal.update(inserirDadosHardwareLocal,
                            idDaMaquina,
                            nomeDisco,
                            tamanhoDisco,
                            modeloDisco,
                            qtdDiscos, 
                            memoriaTotal,
                            processadorNome);
                         
            //Para AZURE
        String inserirDadosHardware = "Insert into ComponentesHardware VALUES" 
                    + "(?,?,?,?,?,?,?);";
        con.update(inserirDadosHardware,
                            idDaMaquina,
                            nomeDisco,
                            tamanhoDisco,
                            modeloDisco,
                            qtdDiscos, 
                            memoriaTotal,
                            processadorNome);
           
             
             System.out.println("nome do disco: " + nomeDisco);
             System.out.println("tamanho do disco: " + tamanhoDisco);
             System.out.println("modelo do disco: " + modeloDisco);
             System.out.println("Quantidade de discos"  + qtdDiscos);
             System.out.println("Memoria total"  + memoriaTotal);
             System.out.println("Nome processador"  + processadorNome);
        }

//-------------------------------INSERT HISTORICO------------------------------
        Date data = new Date();
        
       // LocalDateTime data = LocalDateTime.now();
        
        String tempoInicializado = looca.getSistema().getInicializado().toString();
        String tempoDeAtividade = looca.getSistema().getTempoDeAtividade().toString();
        String temperaturaAtual = looca.getTemperatura().toString();
        Long memoriaEmUso = memoria.getEmUso();
        Long memoriaDisponível = memoria.getDisponivel();
        Double processadorUso = processador.getUso();
        
          timer.scheduleAtFixedRate(new TimerTask() {
             @Override
             public void run() {
                 
           //MySQL local         
            String inserirHistoricoLocal = "Insert into Historico VALUES "
                + "(null,1,?,?,?,?,?,?,?);";
            conLocal.update(inserirHistoricoLocal,idDaMaquina,data,tempoInicializado,tempoDeAtividade,
                   temperaturaAtual,memoriaEmUso,memoriaDisponível,processadorUso);
           
           //AZURE
            String inserirHistorico = "Insert into Historico VALUES "
                + "(?,?,?,?,?,?,?,?);"; 
            con.update(inserirHistorico,idDaMaquina,data,tempoInicializado,tempoDeAtividade,
                   temperaturaAtual,memoriaEmUso,memoriaDisponível,processadorUso);
           

           System.out.println("Data "  + data);
           System.out.println("Tempo inicializado "  + tempoInicializado);
           System.out.println("Tempo de atividade "  + tempoDeAtividade);
           System.out.println("Temperatura atual "  + temperaturaAtual);
           System.out.println("Memoria em uso "  + memoriaEmUso);
           System.out.println("Memoria disponível "  + memoriaDisponível);
           System.out.println("Uso do processador "  + processadorUso);

      }
 },delay,interval);
    }
      
    
    
}
