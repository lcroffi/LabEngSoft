/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import service.UserService;

import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autenticador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<User> users;
    UserService usImpl = new UserService();
    
    public Autenticador() throws ParseException {
        users = usImpl.findAll();
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

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){  
        String id = req.getParameter("id");   
        ServletContext sc = req.getServletContext();
        User uLogado = null;
   
        if (id != null) {
            uLogado = usImpl.findById(Integer.parseInt(id));
            req.setAttribute("usuarioLogado", uLogado);

            try{
                sc.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);            
                } catch (Exception e){}
        }
    }
}
