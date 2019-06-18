package controller;

import model.Candidato;
import model.User;
import service.CandidatoService;
import service.UserService;

import java.text.ParseException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Votacao extends HttpServlet{   
    private static final long serialVersionUID = 1L;
    UserService usImpl = new UserService();
    CandidatoService cImpl = new CandidatoService();

    public Votacao() throws ParseException {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){  
        String id = req.getParameter("id");      
        ServletContext sc = req.getServletContext();
        
        String numero = req.getParameter("numero");
        if (numero != null) {
            Candidato prefeito = cImpl.findPrefeitoByNumero(Integer.parseInt(numero));
            Candidato vice = cImpl.findViceByNumero(Integer.parseInt(numero));
            req.setAttribute("prefeito", prefeito);
            req.setAttribute("vice", vice);
        try{
            sc.getRequestDispatcher("/jsp/votacao.jsp").forward(req, resp);            
            } catch (Exception e){}

        }
        User uLogado = null;
        if (id != null) {
            uLogado = usImpl.findById(Integer.parseInt(id));
            req.setAttribute("usuarioLogado", uLogado);

            try{
            sc.getRequestDispatcher("/jsp/votacao.jsp").forward(req, resp);            
            } catch (Exception e){}
        }

        String confirm = req.getParameter("confirm");     
        if (confirm != null) {
            req.setAttribute("VotoConfirmado", confirm);
            uLogado.setDone(true);
            
            try{
                sc.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);            
                } catch (Exception e){}
        }

    }
}