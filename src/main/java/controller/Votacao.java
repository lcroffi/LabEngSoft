package controller;

import model.User;
import service.DBMockService;

import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Votacao extends HttpServlet{   
    private static final long serialVersionUID = 1L;
    private List<User> users;

    public Votacao() throws ParseException {
        DBMockService dbImpl = new DBMockService();
        users = dbImpl.getUsers();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){        
        ServletContext sc = req.getServletContext();
        req.setAttribute("eleitores", users);

        try{
        sc.getRequestDispatcher("/jsp/votacao.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
}