/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author Daiana
 */
public class LoginController {
    
    private final Login view;
    private LoginHelper helper;
    private UsuarioDAO usuarioDAO;
    private UsuarioDAO UsuarioDAO;
    
    public LoginController(Login view){
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        //PEGAR UM USUARIO DA VIEW
        Usuario usuario = helper.obterModelo();
        //PSQUISAR USUARIO NO BD
        UsuarioDAO = usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado =  usuarioDAO.selectPorNomeESenha(usuario);
        // SE O USUARIO DA VIEW == USUARIO DO BD, DIRECIONAR PARA O MENU
        if(usuarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
       }else{ // ELSE MOSTRAR UMA MSG AO USUARIO 
        view.exibeMensagem("Usuario ou senha invalidos");
    }
 }
    
    public void fizTarefa(){
        System.out.println("Busquei no BD");
        
        this.view.exibeMensagem("executei o fiz tarefa");
    }
            
    
    
}
