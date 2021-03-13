/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroClientes.dao;

import br.com.cadastroClientes.conexao.ConectarMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.cadastroClientes.model.ModelCliente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilber
 */
public class DaoCliente {
    PreparedStatement prepareCliente;;
    Connection conectionCliente;
    ResultSet resultSetCliente;
    String mysqlComando;
    //metodo cadastrar cliente
    public boolean cadastroCliente(ModelCliente modelCliente){
        try {
            conectionCliente = ConectarMysql.getConectar();
        mysqlComando = ""
                + "insert into cliente (nome, endereco, numero, bairro, cidade, uf, cep, email,\n" +
                "cpf, rg, emisor, dtNasc, telefone, celular, informacao)"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        prepareCliente = conectionCliente.prepareStatement(mysqlComando);
        prepareCliente.setString(1, modelCliente.getNome());
        prepareCliente.setString(2, modelCliente.getEndereco());
        prepareCliente.setString(3, modelCliente.getNumero());
        prepareCliente.setString(4, modelCliente.getBairro());
        prepareCliente.setString(5, modelCliente.getCidade());
        prepareCliente.setString(6, modelCliente.getUf());
        prepareCliente.setString(7, modelCliente.getCep());
        prepareCliente.setString(8, modelCliente.getEmail());
        prepareCliente.setString(9, modelCliente.getCpf());
        prepareCliente.setString(10, modelCliente.getRg());
        prepareCliente.setString(11, modelCliente.getEmissor());
        prepareCliente.setString(12, modelCliente.getNasc());
        prepareCliente.setString(13, modelCliente.getTelefone());
        prepareCliente.setString(14, modelCliente.getCelular());
        prepareCliente.setString(15, modelCliente.getInformacao());
        prepareCliente.execute();
        ConectarMysql.fecharConexao();
        return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    //pesquisa de cliente pelo id
    public ModelCliente getPesquisaCliente(int codigo){
        
        ModelCliente modelCliente = null;
        try {
            conectionCliente = ConectarMysql.getConectar();
            mysqlComando = "select *from cliente where codigo = ?";
            prepareCliente = conectionCliente.prepareStatement(mysqlComando);
            prepareCliente.setInt(1, codigo);
            resultSetCliente = prepareCliente.executeQuery();
            while(resultSetCliente.next()){
                modelCliente = new ModelCliente();
                modelCliente.setCodigo(resultSetCliente.getInt(1));
                modelCliente.setNome(resultSetCliente.getString(2));
                modelCliente.setEndereco(resultSetCliente.getString(3));
                modelCliente.setNumero(resultSetCliente.getString(4));
                modelCliente.setBairro(resultSetCliente.getString(5));
                modelCliente.setCidade(resultSetCliente.getString(6));
                modelCliente.setUf(resultSetCliente.getString(7));
                modelCliente.setCep(resultSetCliente.getString(8));
                modelCliente.setEmail(resultSetCliente.getString(9));
                modelCliente.setCpf(resultSetCliente.getString(10));
                modelCliente.setRg(resultSetCliente.getString(11));
                modelCliente.setEmissor(resultSetCliente.getString(12));
                modelCliente.setNasc(resultSetCliente.getString(13));
                modelCliente.setTelefone(resultSetCliente.getString(14));
                modelCliente.setCelular(resultSetCliente.getString(15));
                modelCliente.setInformacao(resultSetCliente.getString(16)); 
            }
            ConectarMysql.fecharConexao();
            return  modelCliente;
        } catch (Exception e) {
        }finally{
            ConectarMysql.fecharConexao();
        }
        return modelCliente;
        
    }
    //pequisa de cliente por nome
    public ModelCliente getPesquisa(String clienteNome){
        
        ModelCliente modelCliente = null;
        try {
            conectionCliente = ConectarMysql.getConectar();
            mysqlComando = "select *from cliente where nome = ?";
            prepareCliente = conectionCliente.prepareStatement(mysqlComando);
            prepareCliente.setString(1, clienteNome);
            resultSetCliente = prepareCliente.executeQuery();
            while(resultSetCliente.next()){
                modelCliente = new ModelCliente();
                modelCliente.setCodigo(resultSetCliente.getInt(1));
                modelCliente.setNome(resultSetCliente.getString(2));
                modelCliente.setEndereco(resultSetCliente.getString(3));
                modelCliente.setNumero(resultSetCliente.getString(4));
                modelCliente.setBairro(resultSetCliente.getString(5));
                modelCliente.setCidade(resultSetCliente.getString(6));
                modelCliente.setUf(resultSetCliente.getString(7));
                modelCliente.setCep(resultSetCliente.getString(8));
                modelCliente.setEmail(resultSetCliente.getString(9));
                modelCliente.setCpf(resultSetCliente.getString(10));
                modelCliente.setRg(resultSetCliente.getString(11));
                modelCliente.setEmissor(resultSetCliente.getString(12));
                modelCliente.setNasc(resultSetCliente.getString(13));
                modelCliente.setTelefone(resultSetCliente.getString(14));
                modelCliente.setCelular(resultSetCliente.getString(15));
                modelCliente.setInformacao(resultSetCliente.getString(16)); 
            }
            ConectarMysql.fecharConexao();
            return  modelCliente;
        } catch (Exception e) {
        }finally{
            ConectarMysql.fecharConexao();
        }
        return modelCliente;
        
    }
    //listar cliente
    public ArrayList<ModelCliente> getListarCliente(){
        ArrayList<ModelCliente> listaCliente = new ArrayList();
        ModelCliente modelCliente = new ModelCliente();
        try {
            conectionCliente = ConectarMysql.getConectar();
            mysqlComando = "select codigo, nome, endereco, numero, bairro, cidade, uf, cep, email, cpf, rg,"
                    + "emisor, dtNasc, telefone, celular, informacao from cliente";
            prepareCliente = conectionCliente.prepareStatement(mysqlComando);
            resultSetCliente = prepareCliente.executeQuery();
            while(resultSetCliente.next()){
                modelCliente = new ModelCliente();
                modelCliente.setCodigo(resultSetCliente.getInt(1));
                modelCliente.setNome(resultSetCliente.getString(2));
                modelCliente.setEndereco(resultSetCliente.getString(3));
                modelCliente.setNumero(resultSetCliente.getString(4));
                modelCliente.setBairro(resultSetCliente.getString(5));
                modelCliente.setCidade(resultSetCliente.getString(6));
                modelCliente.setUf(resultSetCliente.getString(7));
                modelCliente.setCep(resultSetCliente.getString(8));
                modelCliente.setEmail(resultSetCliente.getString(9));
                modelCliente.setCpf(resultSetCliente.getString(10));
                modelCliente.setRg(resultSetCliente.getString(11));
                modelCliente.setEmissor(resultSetCliente.getString(12));
                modelCliente.setNasc(resultSetCliente.getString(13));
                modelCliente.setTelefone(resultSetCliente.getString(14));
                modelCliente.setCelular(resultSetCliente.getString(15));
                modelCliente.setInformacao(resultSetCliente.getString(16)); 
                listaCliente.add(modelCliente);
            }
            ConectarMysql.fecharConexao();
            return  listaCliente;
        } catch (Exception e) {
        }finally{
            ConectarMysql.fecharConexao();
        }
        return listaCliente;
        
    }
    
   public boolean updateClienteDao(ModelCliente cliente){
       try {
           conectionCliente = ConectarMysql.getConectar();
           mysqlComando = "update cliente set nome=?, endereco=?, numero=?, bairro=?, cidade=?, uf=?, cep=?, email=?, cpf=?, rg=?,\n" +
"emisor=?, dtNasc=?, telefone=?, celular=?, informacao=? where codigo = ?";
           prepareCliente = conectionCliente.prepareStatement(mysqlComando);
           prepareCliente.setString(1, cliente.getNome());
           prepareCliente.setString(2, cliente.getEndereco());
           prepareCliente.setString(3, cliente.getNumero());
           prepareCliente.setString(4, cliente.getBairro());
           prepareCliente.setString(5, cliente.getCidade());
           prepareCliente.setString(6, cliente.getUf());
           prepareCliente.setString(7, cliente.getCep());
           prepareCliente.setString(8, cliente.getEmail());
           prepareCliente.setString(9, cliente.getCpf());
           prepareCliente.setString(10, cliente.getRg());
           prepareCliente.setString(11, cliente.getEmissor());
           prepareCliente.setString(12, cliente.getNasc());
           prepareCliente.setString(13, cliente.getTelefone());
           prepareCliente.setString(14, cliente.getCelular());
           prepareCliente.setString(15, cliente.getInformacao());
           prepareCliente.setInt(16, cliente.getCodigo());
           prepareCliente.execute();
           ConectarMysql.fecharConexao();
      
               return true;
           
       } catch (Exception e) {
           return false;
       }
       
   }
   public boolean deleteClienteDao(int codigo){
       
        try {
        conectionCliente = ConectarMysql.getConectar();
       mysqlComando = "delete from cliente where codigo = ?";
            prepareCliente = conectionCliente.prepareStatement(mysqlComando);
            prepareCliente.setInt(1, codigo);
            prepareCliente.execute();
            ConectarMysql.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return true;
   }
}
