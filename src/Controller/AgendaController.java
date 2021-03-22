/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Faz o agendamento 
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import Servico.Correio;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author Daiana
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

    public void atualizaTabela(){
        //Buscar Lista com agendamentos do BD
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        //exibir lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaCliente(){
        //Buscar no BD 
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        //Exibir da tela
        helper.preencherCliente(clientes);
        
    }
    
    public void atualizaServico(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
    }
    
    public void atualizaValor(){
       Servico servico =  helper.obterServico();
       helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        //buscar objt Agendamento da tela  
        Agendamento agendamento = helper.obterModelo();
        //Atualizar no BD 
        new AgendamentoDAO().insert(agendamento);
        
        //Envia email
        Correio correio = new Correio();
        correio.notificarPorEmail(agendamento);
        //inserir na tabela
        atualizaTabela();
        helper.limparTela();     
        
    }
}
