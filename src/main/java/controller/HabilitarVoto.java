package controller;

import model.User;
import service.UserService;

import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HabilitarVoto extends HttpServlet{   
    private static final long serialVersionUID = 1L;
    private List<User> users;
    UserService usImpl = new UserService();

    public HabilitarVoto() throws ParseException {
        users = usImpl.findAll();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){     
        String id = req.getParameter("id");   
        ServletContext sc = req.getServletContext();
        req.setAttribute("eleitores", users);

        User uLogado = null;
        uLogado = usImpl.findById(Integer.parseInt(id));
        req.setAttribute("usuarioLogado", uLogado);

        try{
        sc.getRequestDispatcher("/jsp/cadastro.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
}