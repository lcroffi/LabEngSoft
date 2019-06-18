package controller;

import model.Candidato;
import model.User;
import service.CandidatoService;
import service.UserService;

import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Relatorio extends HttpServlet{   
    private static final long serialVersionUID = 1L;
    UserService usImpl = new UserService();
    CandidatoService cImpl = new CandidatoService();
    List<Candidato> candidatos;

    public Relatorio() throws ParseException {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){  
        String id = req.getParameter("id");      
        ServletContext sc = req.getServletContext();
        candidatos = cImpl.findAll();
        req.setAttribute("candidatos", candidatos);

        User uLogado = null;
        uLogado = usImpl.findById(Integer.parseInt(id));
        req.setAttribute("usuarioLogado", uLogado);

        try{
        sc.getRequestDispatcher("/jsp/relatorio.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
}