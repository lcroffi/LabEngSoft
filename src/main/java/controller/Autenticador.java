/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.EnumRoles;
import model.Role;
import model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autenticador extends HttpServlet {
    private List<User> users;
    private List<Role> roles;
    
    public Autenticador(){
        users = new ArrayList();
        roles = new ArrayList();
        roles.add(new Role(EnumRoles.CHEFE));
        roles.add(new Role(EnumRoles.MESARIO));
        roles.add(new Role(EnumRoles.USUARIO_COMUM));
        //Criação do primeiro usuário do sistema
        User u1 = new User();
        u1.setNumeroTitulo("chefe");
        u1.setSenha("123");
        u1.setRoles(roles);        
        users.add(u1);
        //Criação do segundo usuário do sistema
        roles = new ArrayList();
        roles.add(new Role(EnumRoles.MESARIO));
        roles.add(new Role(EnumRoles.USUARIO_COMUM));
        u1 = new User();
        u1.setNumeroTitulo("mesario");
        u1.setSenha("123");    
        u1.setRoles(roles);
        users.add(u1); 
        //Criação do terceiro usuário do sistema 
        roles = new ArrayList();
        roles.add(new Role(EnumRoles.USUARIO_COMUM));
        u1 = new User();
        u1.setNumeroTitulo("eleitor");
        u1.setSenha("123");    
        u1.setRoles(roles);
        users.add(u1);       
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        
        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
        String numeroTitulo = req.getParameter("numeroTitulo");
        String senha = req.getParameter("senha");
        ServletContext sc = req.getServletContext();
        User uLogado = null;
        for(User u: users){
            if ( numeroTitulo.equals(u.getNumeroTitulo()) 
                 && senha.equals(u.getSenha()) ){
                uLogado = u;
                break;
            }
        }
        if ( uLogado!= null){ //Login efetuado com sucesso
            req.setAttribute("usuarioLogado", uLogado);
            try {
                sc.getRequestDispatcher("/jsp/home.jsp").forward(req, resp); 
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }                       
        }
        else{
            try {
                req.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }  
        }    
    }
}
