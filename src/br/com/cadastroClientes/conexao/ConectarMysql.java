/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroClientes.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gilber
 */
public class ConectarMysql {
    public static String STATUS = "Não conectou";
    //metodo construtor da class

    public ConectarMysql() {
    }
    //metodo de conexão
    public static Connection getConectar(){
       //Declaração atributos
       Connection conexao = null;
       try{
          
          //Carregar o JDBC Driver padrão
          String mysqlDriver = "com.mysql.jdbc.Driver";
          Class.forName(mysqlDriver);
          //configurar: conexão com o bancos de dados mysql
          String servidor = "localhost";//caminho do servidor
          String bancoDados = "cadastrocliente";//banco de dados
          String url = "jdbc:mysql://"+servidor+"/"+bancoDados;
          String user = "root";//usuario bancos de dados
          String pass = "";//senha do banco de dados
          conexao = DriverManager.getConnection(url, user, pass);
          
          if(conexao!=null){
              STATUS = "Conexão realizada com sucesso...";
          }else{
              STATUS ="Falha ao conectar ao banco de dados";
          }
          return conexao;
          
       }catch(ClassNotFoundException erro){
           System.out.println("Driver expecificado não foi encontrado");
        return null;
    }catch(SQLException e){
           System.out.println("Não foi possivel conectar ao banco de dados!");
        return null;
    }
          
}
    //status da conexão
    public static String statusConexao(){
        return STATUS;
    }
    //Metodo que fecha a conexão
    public static boolean fecharConexao(){
        try{
            ConectarMysql.getConectar().close();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }
    //reiniciar conexão
    public static Connection reiniciarConexao(){
        fecharConexao();
        return ConectarMysql.getConectar();
    }
    /*public static void main(String[] args){
      ConectarMysql.getConectar();
        System.out.println(ConectarMysql.statusConexao());
    }*/
}
