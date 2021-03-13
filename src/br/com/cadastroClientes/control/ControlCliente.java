/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroClientes.control;

import br.com.cadastroClientes.dao.DaoCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.cadastroClientes.model.ModelCliente;

/**
 *
 * @author Gilber
 */
public class ControlCliente {
    DaoCliente daoCliente = new DaoCliente();
    public boolean controlCliente(ModelCliente modelCliente){
        return daoCliente.cadastroCliente(modelCliente);
    }
    /*
    *recuperar cliente
    *@paramento codigo
    */
    public ModelCliente getPesquisaCliente(int codigo){
        return daoCliente.getPesquisaCliente(codigo);
    }
    /*
    recuparar cliente
    para string cliente nome
    */
    
    public ModelCliente getPesquisar(String clienteNome){
        return daoCliente.getPesquisa(clienteNome);
        
    }
    /*
    lista de clientes
    */
    public ArrayList<ModelCliente> getControlLista(){
        return daoCliente.getListarCliente();
    }
    /*
    *metedo controle update
    *@paramentro Modelcliente
    */
    public boolean controlUpdateCliente(ModelCliente cliente){
        return daoCliente.updateClienteDao(cliente);
    }
    /*metodo delete
    *
    */
    public boolean controlDeleteCliente(int codigo){
        return daoCliente.deleteClienteDao(codigo);
    }
    
   
        
}
